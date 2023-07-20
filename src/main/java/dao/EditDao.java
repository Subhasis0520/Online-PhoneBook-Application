package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import util.User;

public class EditDao {

	public static User getDetails(int id) {
		User u = null;
		String query = "SELECT * FROM phonebook WHERE id=?";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
		
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setInt(1, id);
		 ResultSet rs = ps.executeQuery();
		 
		 rs.next();
		 int i = rs.getInt(1);
		 String name = rs.getString(2);
		 Long ph = rs.getLong(3);
		 u = new User(id, name, ph);
		 
		 
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
