package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingInDao {

	public static boolean saveSignIn(String name,long phone,String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
			PreparedStatement ps = con.prepareStatement("INSERT INTO signin VALUES(?,?,?,?)");
			ps.setString(1, name);
			ps.setLong(2, phone);
			ps.setString(3, email);
			ps.setString(4, password);
			
		    ps.executeUpdate();
			con.close();
			
			return true;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
}
