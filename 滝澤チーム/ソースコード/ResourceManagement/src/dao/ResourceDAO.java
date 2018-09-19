package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Resource;

public class ResourceDAO {



	public ArrayList<Resource> getResources(int[] classIds) throws SQLException {

		int resourceId = 0;
		String resourceName = null;
		ArrayList<Resource> resource = new ArrayList<Resource>();

		//DB接続に必要なもの
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			for (int i = 0; i < classIds.length; i++) {
				String sql = "select * from RESOURCE where classId = " + classIds[i];

				rs = stmt.executeQuery(sql);
				System.out.println(sql);

				while (rs.next()) {
					//getStringの実引数訂正	★
					resourceId = rs.getInt("RESOURCEID");
					resourceName = rs.getString("RESOURCENAME");
					resource.add(new Resource(resourceId, resourceName));

					System.out.println("id:" + resourceId + "name:" + resourceName);

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			rs.close();
			stmt.close();
			con.close();

		}
		for (int i = 0; i < resource.size(); i++) {
			System.out.println(resource.get(i).getResourceId());
		}
		return resource;

	}

	public void deleteResource(ArrayList<Integer> resourceIds) throws SQLException {
		Connection con = null;
		Statement stmt = null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			for (int resourceId : resourceIds) {
				String sql = "DELETE FROM RESOURCE WHERE  RESOURCEID = " + resourceId;
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


	public void insertResource(int resourceId,String resourceName,String classId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt=null;


		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();
			String sql = "insert into resource(RESOURCEID,RESOURCENAME, CLASSID) values("+resourceId+",'"+resourceName+"',"+classId+")";
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

	public ArrayList<Resource> findName(int[] resourcelds) throws SQLException {

		String resourceName =null;
		ArrayList<Resource> resource =new ArrayList<Resource>();

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

			for(int i=0; i<resourcelds.length; i++) {
				String sql = "select RESOURCENAME from RESOURCE where resourceId = "+resourcelds[i];

				rs = stmt.executeQuery(sql);
				System.out.println(sql);

				while (rs.next()) {
					//getStringの実引数訂正	★
					resourceName = rs.getString("RESOURCENAME");
					resource.add( new Resource(resourcelds[i],resourceName));

					System.out.println("id:"+resourcelds[i]+"name:"+resourceName);

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
		for(int i=0; i<resource.size(); i++ ) {
			System.out.println(resource.get(i).getResourceId());
		}
		return resource;



	}

	public int getResourceIdMAX() throws SQLException {
		//DB接続に必要なもの
				Connection con = null;
				Statement stmt=null;
				ResultSet rs=null;
				int resourceIdMax=0;

				try {

					//"com.mysql.cj.jdbc.Driver"への変換	★
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

					//vietnamがDB名
					//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
					con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
					stmt = con.createStatement();


						String sql = "select MAX(RESOURCEID) as resourceIdMax from RESOURCE";

						rs = stmt.executeQuery(sql);
						System.out.println(sql);

						while (rs.next()) {
							//getStringの実引数訂正	★
							resourceIdMax = rs.getInt("resourceIdMax");
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
		return resourceIdMax;
	}



}
