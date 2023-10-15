package in.arunangshu.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request.getSession().getAttribute("auth")!=null) {
				request.getSession().removeAttribute("auth");
				request.getSession().removeAttribute("total");
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("index.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
