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
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<ResourceClass> clas = new ArrayList<ResourceClass>();

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			String sql = "SELECT * FROM CLASS";

			rs = stmt.executeQuery(sql);

			int classId = 0;
			String className=null;

			while (rs.next()) {
				classId = rs.getInt("classId");
				className = rs.getString("className");

				clas.add(new ResourceClass(classId,className));


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
		return clas;
	}

	public int getClassIdMAX() throws SQLException {
		//DB接続に必要なもの
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		int classIdMax=0;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();


				String sql = "select MAX(CLASSID) as classIdMax from class";

				rs = stmt.executeQuery(sql);
				System.out.println(sql);

				while (rs.next()) {
					//getStringの実引数訂正	★
					classIdMax = rs.getInt("classIdMax");
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
return classIdMax;

	}

	public void insertClass(String classId, String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt=null;


		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();



			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();
			String sql = "insert into class(CLASSID,CLASSNAME) values("+classId+",'"+className+"')";
			System.out.println(sql);

			stmt.executeUpdate(sql);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		finally {
			stmt.close();
			con.close();

		}

	}

	public ArrayList<ResourceClass> findName(int[]classlds) throws SQLException {

		int classId =0;
		String className=null;
		ArrayList<ResourceClass> resourceClass =new ArrayList<ResourceClass>();

		//DB接続に必要なもの
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			for(int i=0; i<classlds.length; i++) {
				String sql = "select * from class where classId = "+classlds[i];

				rs = stmt.executeQuery(sql);
				System.out.println(sql);

				while (rs.next()) {
					//getStringの実引数訂正	★
					classId = rs.getInt("CLASSID");
					className = rs.getString("CLASSNAME");
					resourceClass.add(new ResourceClass(classId,className));

				}
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

		return resourceClass;

	}

	public boolean findClass(int classId) throws SQLException {
		//DB接続に必要なもの
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();


				String sql = "select * from class where classId = "+classId;

				rs = stmt.executeQuery(sql);
				System.out.println(sql);

				if (rs.next()) {
					return true;
				}
				else {
					return false;
				}

		}
		catch(Exception e) {
			System.out.println(e);
			return true;
		}
		finally {
			rs.close();
			stmt.close();
			con.close();

		}


	}

	public void deleteResourceClass() throws SQLException {
		Connection con = null;
		Statement stmt = null;

		ArrayList<Integer> unUseClass = new ArrayList<Integer>();
		unUseClass=unUseClass();

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			for (int id : unUseClass) {
				String sql = "DELETE FROM class WHERE  classid = " + id;
				System.out.println(sql);
				stmt.executeUpdate(sql);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {

			stmt.close();
			con.close();

		}

	}

	public ArrayList<Integer> unUseClass() throws SQLException{
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Integer> unUseClass = new ArrayList<Integer>();

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			java.lang.Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			String sql = "select classid from class where classid not in (select classid from resource );";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				unUseClass.add(rs.getInt("classid"));
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
		return unUseClass;
	}


}
