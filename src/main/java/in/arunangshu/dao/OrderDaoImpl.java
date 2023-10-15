package in.arunangshu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

import in.arunangshu.model.CartID;
import in.arunangshu.model.Order;
import in.arunangshu.model.OrderOutput;
import in.arunangshu.model.Product;

public class OrderDaoImpl implements IOrderDao {
	private static Configuration configuration=null;
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	private static Transaction transaction=null;

	static {
		configuration = new Configuration();
		configuration.addAnnotatedClass(Order.class).addAnnotatedClass(Product.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	@Override
	public void addOrder(int userId, int prodId, int qnt) {
		transaction=session.beginTransaction();
		CartID id = new CartID();
		id.setPid(prodId);
		id.setProjId(userId);
		Order order = new Order();
		order.setQty(qnt);
		order.setId(id);
		session.save(order);
		transaction.commit();	
		transaction=null;
	}

	@Override
	public void deleteOrder(int id) {
		transaction=session.beginTransaction();
		Order order = session.get(Order.class, id);
		session.delete(order);
		transaction.commit();
		transaction=null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderOutput> showOrder(int userId) {
		ProcedureCall call = session.createStoredProcedureCall("retrive_order",Order.class);
		call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(userId);
		
		List<Order> cartAll=call.getResultList();
		
		List<OrderOutput> result=new ArrayList<OrderOutput>();
		
		for(int i=0;i<cartAll.size();i++) {
			Integer pid = cartAll.get(i).getId().getPid();
			Product product = session.get(Product.class, pid);
			OrderOutput c = new OrderOutput();
			c.setId(cartAll.get(i).getOid());
			c.setCategory(product.getCategory());
			c.setName(product.getName());
			
			int a= Integer.parseInt(product.getPrice())*cartAll.get(i).getQty();
			c.setPrice(a);
			c.setQty(cartAll.get(i).getQty());
			c.setCreationdate(cartAll.get(i).getCreationdate());
			result.add(c);
		}
		
		session.clear();
				
		return result;
	}

}
