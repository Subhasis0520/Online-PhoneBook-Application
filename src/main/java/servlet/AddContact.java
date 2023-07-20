package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;

@WebServlet("/addcontact")
public class AddContact extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		
		boolean res = ContactDao.saveContact(name, phone, email);

		if(res) {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
	        out.println("<head>");
	        out.println("<style>");
	        out.println("body {");
	        out.println("    background-color:  rgb(128, 128, 128);");
	        out.println("    font-family: Arial, sans-serif;");
	        out.println("}");
	        out.println("h3 {");
	        out.println("    color: green;");
	        out.println("    text-align: center;");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
		    out.println("<h3> DATA SAVED SUCCESSFULLY!!! </h3>");
		    out.println("</body>");
	        out.println("</html>");
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.include(req, resp);
			}else {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
		        out.println("<head>");
		        out.println("<style>");
		        out.println("body {");
		        out.println("    background-color:  rgb(128, 128, 128);");
		        out.println("    font-family: Arial, sans-serif;");
		        out.println("}");
		        out.println("h3 {");
		        out.println("    color: red;");
		        out.println("    text-align: center;");
		        out.println("}");
		        out.println("</style>");
		        out.println("</head>");
		        out.println("<body>");
			    out.println("<h3> SOMETHING WENT WRONG!!! PLEASE TRY AGAIN.... </h3>");
			    out.println("</body>");
		        out.println("</html>");
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
			}
	}
}
