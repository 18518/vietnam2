package dao;

import java.sql.Connection;

public class DAOFactory {
	private DAOFactory instance = null;


	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAO();
	}

	public ReserveDAO getReserveDAO() {
		return new ReserveDAO();
	}

	public ResourceDAO getResouceDAO() {
		return new ResourceDAO();
	}
}
