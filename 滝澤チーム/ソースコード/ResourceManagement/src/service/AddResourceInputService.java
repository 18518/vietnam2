package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import domain.ResourceClass;
import dto.ResourceClassDTO;

public class AddResourceInputService {

	public ResourceClassDTO getClassName(int classId) throws SQLException {

		String className = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO classDAO = daoFactory.getClassDAO();

		ArrayList<ResourceClass> showName = new ArrayList<ResourceClass>();
		showName = classDAO.showName();

		for (ResourceClass cla : showName) {
			if (classId == cla.getClassId()) {
				className = cla.getClassName();
				break;
			}
		}

		ResourceClassDTO dto=new ResourceClassDTO(classId, className);

		return dto;
	}

}
