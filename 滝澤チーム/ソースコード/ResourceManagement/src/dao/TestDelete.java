package dao;

import java.sql.SQLException;

public class TestDelete {

	public static void main(String[] args) throws SQLException {

		DAOFactory instance=DAOFactory.getInstance();
		ReserveDAO dao=instance.getReserveDAO();
		dao.delete(23456789, 12);

	}

}
