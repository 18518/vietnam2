package dao;

public class DAOFactory {
	private static DAOFactory instance = null;

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
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

	public ResourceClassDAO getClassDAO() {
		return new ResourceClassDAO();
	}

}
