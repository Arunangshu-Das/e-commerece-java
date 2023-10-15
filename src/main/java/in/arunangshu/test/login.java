package in.arunangshu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.arunangshu.dao.IUserDao;
import in.arunangshu.dao.userDaoImpl;
import in.arunangshu.model.User;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			String email=request.getParameter("login-email");
			String password=request.getParameter("login-password");
			IUserDao udao=new userDaoImpl();
			User user = udao.userLogin(email, password);
			if(user!=null) {
//				out.print(user.getEmail()+user.getName());
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("noUser.jsp");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
