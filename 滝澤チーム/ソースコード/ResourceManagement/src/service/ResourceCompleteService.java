package service;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import dao.ResourceDAO;

public class ResourceCompleteService {

	public void insertClass(String classId,String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();
		resourceClassDAO.insertClass(classId,className);
	}
	public boolean findClass(int classId) throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();
		return resourceClassDAO.findClass(classId);
	}

	public void insertResource(int resourceId,String resourceName,String classId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		resourceDAO.insertResource(resourceId,resourceName, classId);
	}
}
