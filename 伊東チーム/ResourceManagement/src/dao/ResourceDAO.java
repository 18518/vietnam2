package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Resource;

public class ResourceDAO {


	public ArrayList<Resource> findName(String[] resources) throws SQLException{

		ArrayList<Resource> rscList = new ArrayList<Resource>();

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
			for(String resourceIds:resources) {

			String sql = "select * from RESOURCE where resourceId = "+resourceIds;

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				//getStringの実引数訂正	★
				int resourceId = rs.getInt("RESOURCEID");
				String resourceName = rs.getString("RESOURCENAME");
				rscList.add(new Resource(resourceId,resourceName));
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

		return rscList;
	}

}
