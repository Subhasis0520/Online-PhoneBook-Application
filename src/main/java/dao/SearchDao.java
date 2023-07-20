package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.User;

public class SearchDao {

	public static User search(String name) {
		User u = null;
		String query = "SELECT * FROM phonebook WHERE name=?";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
		
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setString(1, name);
		 ResultSet rs = ps.executeQuery();
		 
		 rs.next();
		 u = new User(rs.getInt(1), rs.getString(2),rs.getLong(3),rs.getString(4));
			 
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
}
}
