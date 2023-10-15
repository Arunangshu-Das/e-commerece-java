package in.arunangshu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import in.arunangshu.model.Cart;
import in.arunangshu.model.CartID;
import in.arunangshu.model.Product;
import in.arunangshu.model.cartOutput;

public class cartDaoImpl implements ICartDao {
	private static Configuration configuration=null;
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	private static Transaction transaction=null;

	static {
		configuration = new Configuration();
		configuration.addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	
	
	@Override
	public Cart addCart(int userId, int prodId) {
		transaction=session.beginTransaction();
		CartID cartId = new CartID(prodId,userId);
		Cart cart=session.get(Cart.class, cartId);
		if(cart!=null) {
			transaction.commit();
			return cart;
		}
		else {
			Cart cart2 = new Cart(cartId,1);
			session.save(cart2);
			transaction.commit();
			transaction=null;
			return cart2;
		}
	}

	@Override
	public Integer incCart(int userId, int prodId) {
		transaction=session.beginTransaction();
		CartID cartId = new CartID(prodId,userId);
		Cart cart=session.get(Cart.class, cartId);
		cart.setQty(cart.getQty()+1);
		session.save(cart);
		transaction.commit();
		transaction=null;
		
		return cart.getQty()+1;
	}

	@Override
	public Integer decCart(int userId, int prodId) {
		transaction=session.beginTransaction();
		CartID cartId = new CartID(prodId,userId);
		Cart cart=session.get(Cart.class, cartId);
		int a=cart.getQty();
		if(a>1)
			a-=1;
		cart.setQty(a);
		session.save(cart);
		transaction.commit();
		transaction=null;
		
		
		
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<cartOutput> showCart(int userId) {
		ProcedureCall call = session.createStoredProcedureCall("retrive_cart",Cart.class);
		call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(userId);
		
		List<Cart> cartAll=call.getResultList();
		
		List<cartOutput> result=new ArrayList<cartOutput>();
		
		for(int i=0;i<cartAll.size();i++) {
			Integer pid = cartAll.get(i).getId().getPid();
			Product product = session.get(Product.class, pid);
			cartOutput c = new cartOutput();
			c.setId(pid);
			c.setCategory(product.getCategory());
			c.setName(product.getName());
			
			int a= Integer.parseInt(product.getPrice())*cartAll.get(i).getQty();
			c.setPrice(a);
			c.setQty(cartAll.get(i).getQty());
			result.add(c);
		}
		
		session.clear();
				
		return result;
	}

	@Override
	public void deleteCart(int userId, int prodId) {
		transaction=session.beginTransaction();
		CartID cartId = new CartID(prodId,userId);
		Cart cart=session.get(Cart.class, cartId);
		if(cart!=null) {
			session.delete(cart);
		}
		transaction.commit();
		transaction=null;
	}

	@Override
	public void checkout(int userId) {
		ProcedureCall call = session.createStoredProcedureCall("retrive_cart",Cart.class);
		call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(userId);
		
		List<Cart> cartAll=call.getResultList();
		
		for(int i=0;i<cartAll.size();i++) {
			Integer pid = cartAll.get(i).getId().getPid();
			int qty=cartAll.get(i).getQty();
			IOrderDao dao=new OrderDaoImpl();
			dao.addOrder(userId, pid, qty);
			dao=null;
			deleteCart(userId, pid);
		}
		
	}

}
