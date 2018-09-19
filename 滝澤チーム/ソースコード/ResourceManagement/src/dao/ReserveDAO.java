package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import domain.Reserve;
import domain.Resource;

public class ReserveDAO {

	public void insert(int reserveId, LocalDateTime lendDate, LocalDateTime returnDate, String empId, int resourceId)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
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
			String sql = "insert into reserve(RESERVEID,LENDDATE,RETURNDATE,EMPID,RESOURCEID) values("+reserveId+",'"+lendDate+"','"+returnDate+"','"+empId+"',"+resourceId+")";

			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			stmt.close();
			con.close();

		}

	}

	public ArrayList<Reserve> find(int reserveId, String empId) throws SQLException {
		LocalDateTime lendDate = null;
		LocalDateTime returnDate = null;
		int resourceId = 0;
		ArrayList<Reserve> reserve = new ArrayList<Reserve>();

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
			String sql = "SELECT LENDDATE,RETURNDATE,RESOURCEID FROM reserve where reserveId = "+reserveId+" AND empId = '"+empId+"'";
			rs=stmt.executeQuery(sql);

			while(rs.next()) {
				DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				lendDate = LocalDateTime.parse(rs.getString("LENDDATE"), f);
				returnDate = LocalDateTime.parse(rs.getString("RETURNDATE"), f);
				resourceId = rs.getInt("RESOURCEID");
				reserve.add(new Reserve(reserveId, lendDate, returnDate, empId, resourceId));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return reserve;
	}

	public void delete(int reserveId, int resourceId) throws SQLException {
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

			String sql = "DELETE FROM RESERVE WHERE RESERVEID = " + reserveId + " AND RESOURCEID = " + resourceId;

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {

			stmt.close();
			con.close();

		}

	}

	public ArrayList<Resource> search(LocalDateTime lendDate, LocalDateTime returnDate, int[] classId)
			throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Resource> resources = new ArrayList<Resource>();
		int resourceId = 0;
		String resourceName = null;
		{
			try {

				//"com.mysql.cj.jdbc.Driver"への変換	★
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				//vietnamがDB名
				//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
				stmt = con.createStatement();

				for (int i = 0; i < classId.length; i++) {
					String sql = "SELECT resourceid, resourcename FROM resource B where B.classid = " + classId[i]
							+ " and not B.resourceid in (select resourceid from reserve where ('" + lendDate
							+ "' < reserve.lenddate and reserve.lenddate <'" + returnDate + "') or ('" + lendDate
							+ "' < reserve.returndate and reserve.returndate <'" + returnDate
							+ "') or (reserve.lenddate <= '" + lendDate + "' AND returndate >= '" + returnDate + "'))";
					rs = stmt.executeQuery(sql);

					Resource resourceIds;
					while (rs.next()) {
						resourceId = rs.getInt("resourceId");
						resourceName = rs.getString("resourceName");

						resourceIds = new Resource(resourceId, resourceName);

						resources.add(resourceIds);

					}
				}

			}catch(Exception e) {
				System.out.println(e);
			}

			finally {
				rs.close();
				stmt.close();
				con.close();

			}

		}

		return resources;
	}

	public boolean isUniqueId(int createReserveId) throws SQLException {
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
			String sql = "SELECT reserveId FROM reserve where reserveId = "+createReserveId;
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			System.out.println(e);
			return true;
		}finally {
			rs.close();
			stmt.close();
			con.close();
		}

	}

	public void deletePreviousReserve() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		LocalDateTime now = LocalDateTime.now();

		try {

			//"com.mysql.cj.jdbc.Driver"への変換	★
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			//vietnamがDB名
			//characterEncoding=UTF-8&serverTimezone=JSTの追記	★
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
			stmt = con.createStatement();

			String sql = "DELETE FROM RESERVE WHERE LENDDATE < '" + now + "' AND RETURNDATE < '" + now + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {

			stmt.close();
			con.close();

		}

	}

}
