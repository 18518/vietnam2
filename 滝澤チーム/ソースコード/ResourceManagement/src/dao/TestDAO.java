package dao;

import java.sql.SQLException;

public class TestDAO {

	public static void main(String[] args) {
		//DAOクラスのテストクラス
		EmployeeDAO dao = new EmployeeDAO();
		try {
			System.out.println(dao.find("11111").getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

