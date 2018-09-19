package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ReserveDAO;
import dao.ResourceClassDAO;
import dao.ResourceDAO;
import dto.ResourceDTO;

public class DeleteCompleteService {

	public void deleteResource(ArrayList<ResourceDTO> resourceDTO) throws SQLException {

		ArrayList<Integer> resourceIds = new ArrayList<Integer>();
		for(ResourceDTO dto:resourceDTO) {
			resourceIds.add(dto.getResourceId());
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		ReserveDAO reserveDAO = daoFactory.getReserveDAO();
		reserveDAO.deletePreviousReserve();
		ResourceDAO resourceDAO=daoFactory.getResourceDAO();
		resourceDAO.deleteResource(resourceIds);

	}

	public void deleteResourceClass() throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO classDAO = daoFactory.getClassDAO();
		classDAO.deleteResourceClass();
	}
}
