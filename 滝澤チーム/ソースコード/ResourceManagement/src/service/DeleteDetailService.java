package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceDAO;
import domain.Resource;
import dto.ResourceDTO;

public class DeleteDetailService {

	public ArrayList<ResourceDTO> getResources(int[] classIds) throws SQLException{

		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO dao=daoFactory.getResourceDAO();

		ArrayList<Resource> resources = new ArrayList<Resource>();
		resources=dao.getResources(classIds);
		ArrayList<ResourceDTO> resourceDTO = new ArrayList<ResourceDTO>();
		for(int i=0; i<resources.size(); i++) {
			resourceDTO.add(new ResourceDTO(resources.get(i).getResourceId(),resources.get(i).getResourceName()));
		}
		return resourceDTO;
	}
}
