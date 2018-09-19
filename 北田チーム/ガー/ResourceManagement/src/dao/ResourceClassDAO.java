package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResourceClassDAO {

	public ArrayList<String> getClassNames() throws SQLException{

		//DB接続に必要なもの
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;

		ArrayList<String> classNames = new ArrayList<String>();
		String name;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

			stmt = con.createStatement();

			String sql = "select classname from class;";

			rs = stmt.executeQuery(sql);


			while (rs.next()) {
				name = rs.getString("classname");
				classNames.add(name);
			}

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			stmt.close();
			con.close();

		}
		return classNames;
	}
}

