package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactDao {

	public static boolean saveContact(String name, long phone, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
			PreparedStatement ps = con.prepareStatement("INSERT INTO phonebook(name,phone,email) VALUES(?,?,?)");
			ps.setString(1, name);
			ps.setLong(2, phone);
			ps.setString(3, email);
			
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
	
	
	public static ResultSet getAllContacts(String email) {
		String query = "SELECT * FROM phonebook WHERE email='"+email+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			return rs;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}




    