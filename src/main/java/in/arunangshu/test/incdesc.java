package in.arunangshu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.arunangshu.dao.ICartDao;
import in.arunangshu.dao.cartDaoImpl;
import in.arunangshu.model.User;

public class incdesc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("auth");
		if(user!=null) {
			Integer uid=user.getId();
			String action=request.getParameter("action");
			int id=Integer.parseInt(request.getParameter("id"));
			if(action!=null & id >=4) {
				if(action.equals("inc")) {
					ICartDao dao=new cartDaoImpl();
					dao.incCart(uid, id);
				}
				else if(action.equals("dec")) {
					ICartDao dao=new cartDaoImpl();
					dao.decCart(uid, id);
				}
				response.sendRedirect("cart.jsp");
			}
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
