package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import domain.Reserve;
import domain.Resource;

public class ReserveDAO {

	public void insert(Reserve reserve) throws SQLException {
		//DB接続に必要なもの
		Connection con = null;
		PreparedStatement pstmt=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

			String sql = "Insert into Reserve Values(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reserve.getReserveId());
			pstmt.setTimestamp(2, Timestamp.valueOf(reserve.getLendDate()));
			pstmt.setTimestamp(3, Timestamp.valueOf(reserve.getReturnDate()));
			pstmt.setString(4, reserve.getEmpId());
			pstmt.setInt(5, reserve.getResourceId());

			pstmt.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			pstmt.close();
			con.close();

		}

	}




	public ArrayList<Reserve> find(int reserveId,String empId) throws SQLException {
		ArrayList<Reserve> rsvList = new ArrayList<Reserve>();

		//DB接続に必要なもの
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");


			String sql = " select * from RESERVE reserveId = ? AND empId = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,reserveId);
			pstmt.setString(2, empId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				//getStringの実引数訂正	★
				reserveId = rs.getInt("RESERVEID");
				LocalDateTime lendDate = (rs.getTimestamp("LENDDATE")).toLocalDateTime();
				LocalDateTime returnDate =  (rs.getTimestamp("RETURNDATE")).toLocalDateTime();
				empId = rs.getString("EMPID");
				int resourceId = rs.getInt("RESOURCEID");
				rsvList.add(new Reserve(reserveId,lendDate,returnDate,empId, resourceId));
			}


		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			pstmt.close();
			con.close();

		}



		return rsvList;

	}

	public void delete(int reserveId,int resourceId) throws SQLException {
		//DB接続に必要なもの
		Connection con = null;
		PreparedStatement pstmt=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

			String sql = "delete from reserve where reserveId = ? and resourceId = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reserveId);
			pstmt.setInt(2, resourceId);

			pstmt.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			pstmt.close();
			con.close();

		}



	}

	public boolean isUniqueId(int reserveId) throws SQLException {
			boolean frag = false;

			//DB接続に必要なもの
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			try {

				//"com.mysql.cj.jdbc.Driver"への変換	★
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				//vietnamがDB名
				//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
				con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

				String sql = " select * from RESERVE where reserveid = ? ";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, reserveId);

				rs = pstmt.executeQuery();

				if (reserveId == rs.getInt("RESERVEID")) {
					frag = true;
				}

			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				rs.close();
				pstmt.close();
				con.close();

			}
			return frag;
	}




	public ArrayList<Resource> search(LocalDateTime lendDate, LocalDateTime returnDate, int[] classIds) throws SQLException {

		ArrayList<Resource> rscList = new ArrayList<Resource>();

		//DB接続に必要なもの
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");

			String sql = " SELECT resourceid, resourcename FROM resource B where B.classid = ? and not B.resourceid in (select resourceid from reserve where (? < reserve.lenddate and reserve.lenddate < ?) or (? < reserve.returndate and reserve.returndate <?) or (reserve.lenddate <= ? AND returndate >= ?))";

			pstmt = con.prepareStatement(sql);
			pstmt.setTimestamp(2,  Timestamp.valueOf(lendDate));
			pstmt.setTimestamp(3,  Timestamp.valueOf(returnDate));
			pstmt.setTimestamp(4,  Timestamp.valueOf(lendDate));
			pstmt.setTimestamp(5,  Timestamp.valueOf(returnDate));
			pstmt.setTimestamp(6,  Timestamp.valueOf(lendDate));
			pstmt.setTimestamp(7,  Timestamp.valueOf(returnDate));

			for(int classId:classIds) {
			pstmt.setInt(1, classId);

			rs = pstmt.executeQuery();

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
			pstmt.close();
			con.close();

		}



		return rscList;
	}



}
