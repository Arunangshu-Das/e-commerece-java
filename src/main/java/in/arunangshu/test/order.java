package in.arunangshu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.arunangshu.dao.IOrderDao;
import in.arunangshu.dao.OrderDaoImpl;
import in.arunangshu.model.User;


public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("auth");
		if(user!=null) {
			Integer uid=user.getId();
			Integer prodid=Integer.parseInt(request.getParameter("id"));
			Integer quantity=Integer.parseInt(request.getParameter("quantity"));
			if(quantity<1) quantity=1;
			IOrderDao dao=new OrderDaoImpl();
			dao.addOrder(uid, prodid, quantity);
			response.sendRedirect("orders.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
