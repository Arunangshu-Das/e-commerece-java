package in.arunangshu.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.arunangshu.dao.IOrderDao;
import in.arunangshu.dao.OrderDaoImpl;
import in.arunangshu.model.User;

public class cancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("auth");
		if(user!=null) {
			int id=Integer.parseInt(request.getParameter("id"));
			IOrderDao dao=new OrderDaoImpl();
			dao.deleteOrder(id);
			response.sendRedirect("orders.jsp");
		}
		else {
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
