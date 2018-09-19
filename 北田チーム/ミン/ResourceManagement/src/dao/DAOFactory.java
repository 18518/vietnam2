package dao;

public class DAOFactory {
	private DAOFactory instance = null;


	public DAOFactory() {

	}
	
	
	
	public static DAOFactory getInstance() {
		return new DAOFactory();
	}
	
	public ResourceClassDAO getResourceClassDAO() {
		return new ResourceClassDAO();
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
