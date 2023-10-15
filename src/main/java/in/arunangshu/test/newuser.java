package in.arunangshu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.arunangshu.dao.IUserDao;
import in.arunangshu.dao.userDaoImpl;

/**
 * Servlet implementation class newuser
 */
public class newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String emails = request.getParameter("emails");
			String pass = request.getParameter("pass");
			IUserDao dao=new userDaoImpl();
			dao.userSignUp(fname+" "+lname, emails, pass);
			response.sendRedirect("index.jsp");
		}
		catch(Exception e) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
