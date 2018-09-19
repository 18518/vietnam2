package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import dao.ResourceDAO;
import domain.Resource;

public class ResourceConfirmService {

	public void insertClass(String classId,String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();

		resourceClassDAO.insertClass(classId,className);
	}


	public ArrayList<Resource> findName(int[] resourceIds) throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		return resourceDAO.findName(resourceIds);
	}


	public int getResourceIdMAX() throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		return resourceDAO.getResourceIdMAX();
	}

}
