package in.arunangshu.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.arunangshu.dao.ICartDao;
import in.arunangshu.dao.cartDaoImpl;
import in.arunangshu.model.User;


public class showCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("auth");
		if(user!=null) {
			Integer uid=user.getId();
			ICartDao cart=new cartDaoImpl();
			cart.showCart(uid);
			
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
