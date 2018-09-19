package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import domain.Reserve;

public class ReserveDAO {



	public  Reserve find(int reserveId) throws SQLException{
		//DB検索してるところ
		Reserve reserve = null;
		int reserveid  =0;
		LocalDateTime lendDate =null;
		LocalDateTime returnDate = null;
		String empId = null;
		int resourceId = 0;


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

			String sql = " select * from RESERVE where reserveId = "+reserveId;

			rs = stmt.executeQuery(sql);


			while (rs.next()) {
				//getStringの実引数訂正	★
				reserveid = rs.getInt("RESERVEDID");
				String x = rs.getString("LENDDATE");
				String y =  rs.getString("RETURNDATE");
				DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				lendDate = LocalDateTime.parse(x, dtf);
				returnDate =LocalDateTime.parse(y, dtf);
				empId = rs.getString("EMPID");
				resourceId = rs.getInt("RESOURCEID");
			}

			reserve  = new  Reserve(reserveId,lendDate ,returnDate,empId,resourceId);

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			stmt.close();
			con.close();

		}
		return reserve;
	}

	public void  insert( Reserve  reserve) throws SQLException{

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

			String sql = " insert  into RESERVE values("+reserve.getReserveId+","+ reserve.getLendDate+"," +reserve.getReturnDate+","+reserve.getEmpId+","+reserve.getResourceId+")";

			stmt.executeUpdate(sql);

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			stmt.close();
			con.close();

		}
	}
		public void delete(int reserveId, int resourceId) throws SQLException{
			Reserve reserve = null;

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

				String sql = " delete from RESERVE where reserveId =" + reserveId + "AND" + "resourceId=" +resourceId  ;

				stmt.executeUpdate(sql);

		}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
			rs.close();
			stmt.close();
			con.close();
			}
		}

		public Resource search(LocalDateTime lendDate,LocalDateTime returnDate, int classId)throws SQLException {
			Resource a = null;

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

				String sql  /* = sql*/;

				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					//getStringの実引数訂正	★
					int resourceId = rs.getInt("RESOURCEID");
					String resourceName = rs.getString("RESOURCENAME");

					classId = rs.getInt("CLASSID");
				}
				a = new Resource(resourceId, resourceName);

			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
			rs.close();
			stmt.close();
			con.close();
			}
			return a;
		}
	}




