package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceDAO {

	public Resource resourceSearch(Resource resourceId, String resourceName) {
		// TODO 自動生成されたコンストラクター・スタブ
		return resourceId;
	}

	public Resource find1(String id) throws SQLException{
			//DB検索してるところ
			Resource resource = null;
			Integer resourceId = null;
			String resourceName = null;
			Integer classId = null;

			//DB接続に必要なもの
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {

				//"com.mysql.cj.jdbc.Driver"への変換	★
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				//vietnamがDB名
				//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
				con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=thuha151020&");

				stmt = con.createStatement();

				String sql = " select * from RESOURCE where resourceid = "+id;

				rs = stmt.executeQuery(sql);


				while (rs.next()) {
					//getStringの実引数訂正	★
					resourceId = rs.getInt("RESOURCEID");
					resourceName = rs.getString("RESOURCENAME");
					classId = rs.getInt("CLASSID");
				}
				 resource = new Resource(resourceId, resourceName);

			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				rs.close();
				stmt.close();
				con.close();
			}
			return resource;
		}

	public Resource findName(Resource resourceId) {
		return resourceId;
	}
		public Resource find2(String id) throws SQLException{
			//DB検索してるところ
			Resource resource=null;
			Integer resourceId=null;
			String resourceName=null;
			Integer classId = null;

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
					resourceId = rs.getInt("RESOURCEID");
					resourceName = rs.getString("RESOURCENAME");
					classId = rs.getInt("CLASSID");
				}
				resource = new Resource(resourceId, resourceName);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				rs.close();
				stmt.close();
				con.close();
			}
			return resource;
		}
}
