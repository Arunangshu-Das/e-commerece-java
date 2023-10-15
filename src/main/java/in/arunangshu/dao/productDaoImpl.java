package in.arunangshu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import in.arunangshu.model.Product;

public class productDaoImpl implements IProductDao {

	private static Configuration configuration=null;
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	private Transaction transaction=null;
	int save=-1;

	static {
		configuration = new Configuration();
		configuration.addAnnotatedClass(Product.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public String uploadProduct(String name, String category, String price, byte[] image) {
		try {
			transaction = session.beginTransaction();
			if(transaction!=null) {
				Product product = new Product();
				product.setCategory(category);
				product.setImage(image);
				product.setName(name);
				product.setPrice(price);
				
				save = (int) session.save(product);
				transaction.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		finally{
			if(save>0) {
				return "Success";
			}
			return "Failure";
		}
	}

	@Override
	public List<Product> getAllProduct() {
		Query<Product> query = session.createQuery("From in.arunangshu.model.Product");
		List<Product> list = query.getResultList();
		return list;
	}

}
