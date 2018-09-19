package service;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.ReserveDAO;

public class CancelService {

	public void delete(int reserveId, int[] resourceIds) throws SQLException {

		DAOFactory instance = DAOFactory.getInstance();
		ReserveDAO reserveDAO = instance.getReserveDAO();

		for (int resourceId : resourceIds) {
			reserveDAO.delete(reserveId, resourceId);
		}
	}

}
