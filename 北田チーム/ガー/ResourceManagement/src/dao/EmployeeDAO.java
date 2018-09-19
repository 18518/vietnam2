package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Employee;

public class EmployeeDAO {


		public Employee find(String id) throws SQLException{
			//DB検索してるところ
			Employee employee=null;
			String empId=null;
			String name=null;
			String pass=null;

			//DB接続に必要なもの
			Connection con = null;
			Statement stmt=null;
			ResultSet rs=null;

			try {

				//"com.mysql.cj.jdbc.Driver"への変換	★
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				//vietnamがDB名
				//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
				con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=thuha151020&");

				stmt = con.createStatement();

				String sql = " select * from EMPLOYEE where empid = "+id;

				rs = stmt.executeQuery(sql);


				while (rs.next()) {
					//getStringの実引数訂正	★
					empId = rs.getString("EMPID");
					name = rs.getString("EMPname");
					pass = rs.getString("passwd");
				}

				employee = new Employee(empId,name,pass);

			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				rs.close();
				stmt.close();
				con.close();

			}
			return employee;
		}


}