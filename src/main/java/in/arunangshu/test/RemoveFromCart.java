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

public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("auth");
		if(user!=null) {
			Integer uid=user.getId();
			int id=Integer.parseInt(request.getParameter("id"));
				ICartDao dao=new cartDaoImpl();
				dao.deleteCart(uid, id);
				response.sendRedirect("cart.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}
