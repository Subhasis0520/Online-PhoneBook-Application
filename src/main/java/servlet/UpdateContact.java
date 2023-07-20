package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateContact extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        long phone = Long.parseLong(req.getParameter("phone"));
        
        
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone_book","root","Subhasis@123");
			
			String query = "UPDATE phonebook SET name=?,phone=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setLong(2, phone);
			ps.setInt(3, id);
		    ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
        rd.forward(req, resp);
	}
}
