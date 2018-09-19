package dao;

public class DAOFactory {

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

	public ResourceDAO getResourceDAO() {
		return new ResourceDAO();
	}

	public ResourceClassDAO getResourceClassDAO() {
		return new ResourceClassDAO();
	}

}
