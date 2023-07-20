package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

@WebServlet("/validatelogin")
public class ValidateLogin extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		
		boolean res = LoginDao.validateLogin(email, password);
		
		if(res) {
			HttpSession hs = req.getSession();
			hs.setAttribute("email",email);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}else {
			resp.setContentType("text/html");
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
			    out.println("<h3> EMAIL/PASSWORD IS INCORRECT!!! </h3>");
			    out.println("</body>");
		        out.println("</html>");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
		
	}
}
