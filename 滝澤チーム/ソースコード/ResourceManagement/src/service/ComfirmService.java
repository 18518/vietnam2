package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceDAO;
import domain.Resource;
import dto.ResourceDTO;

public class ComfirmService {

	public ComfirmService() {

	}

	public ArrayList<ResourceDTO> findName(int[] resourceIds) throws SQLException {
		ArrayList<Resource> resource = new ArrayList<Resource>();
		DAOFactory daoFactory=DAOFactory.getInstance();
		ResourceDAO resourceDAO =daoFactory.getResourceDAO();
		resource=resourceDAO.findName(resourceIds);

		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		for(int i=0; i<resource.size(); i++) {
		resourceDTO.add(new ResourceDTO(resource.get(i).getResourceId(),resource.get(i).getResourceName()));
		}
		return resourceDTO;
	}
}
