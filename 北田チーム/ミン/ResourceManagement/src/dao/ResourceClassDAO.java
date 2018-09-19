package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.ResourceClass;

public class ResourceClassDAO {

	public ArrayList<ResourceClass> showName() throws SQLException{

		//DB接続に必要なもの
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;

		ArrayList<ResourceClass> classNames = new ArrayList<ResourceClass>();
		String name;
		int id;
		ResourceClass rc = new ResourceClass();

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

			stmt = con.createStatement();

			String sql = "select * from class;";

			rs = stmt.executeQuery(sql);


			while (rs.next()) {
				name = rs.getString("classname");
				id = rs.getInt("classId");
				rc = new ResourceClass(id, name);
				classNames.add(rc);
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

