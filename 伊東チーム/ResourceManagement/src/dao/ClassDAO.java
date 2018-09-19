package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Class;;

public class ClassDAO {


	//public ArrayList<Class> showName(Class[] classes) throws Exception {
	public ArrayList<Class> showName() throws Exception {
		int classId;
		String className;
		ArrayList<Class> classList = new ArrayList<Class>();
		ResultSet rs =null;
		//DAOFactory df= DAOFactory.getInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakuradb?characterEncoding=UTF-8&serverTimezone=JST&user=root&password=");
		PreparedStatement pstmt=null;

		try {

			//for(int i=0; i<classes.length; i++) {
				//String sql = "SELECT * FROM class where CLASSID = "+classes[i].getClassId();
				String sql = "SELECT * FROM class";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					//getStringの実引数訂正	★
					classId = rs.getInt("CLASSID");
					className = rs.getString("CLASSNAME");
					classList.add((new Class(classId,className)));
				}
			//}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			pstmt.close();
			con.close();
		}

		return classList;

	}


}
