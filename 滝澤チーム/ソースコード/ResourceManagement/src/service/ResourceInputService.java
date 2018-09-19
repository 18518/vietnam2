package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.ResourceClassDAO;
import dao.ResourceDAO;
import domain.ResourceClass;

public class ResourceInputService {

	public ResourceInputService() {
	}

//	public void insertResource(String resourceName,String classId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		DAOFactory daoFactory = DAOFactory.getInstance();
//		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
//		resourceDAO.insertResource(resourceName, classId);
//	}

	public void insertClass(String classId,String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();

		resourceClassDAO.insertClass(classId,className);
	}
	public void insertResource(int resourceId,String resourceName,String classId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		resourceDAO.insertResource(resourceId,resourceName, classId);
	}

	public ArrayList<ResourceClass> findName(int[] resourceIds) throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();
		return resourceClassDAO.findName(resourceIds);
	}

	public int getClassIdMAX() throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceClassDAO resourceClassDAO = daoFactory.getClassDAO();
		return resourceClassDAO.getClassIdMAX();
	}

	public int getResourceIdMAX() throws SQLException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		ResourceDAO resourceDAO = daoFactory.getResourceDAO();
		return resourceDAO.getResourceIdMAX();
	}

}
