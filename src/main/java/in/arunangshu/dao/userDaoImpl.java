package in.arunangshu.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import in.arunangshu.model.User;

public class userDaoImpl implements IUserDao {

	private static Configuration configuration=null;
	private static SessionFactory sessionFactory=null;
	private static Session session=null;

	static {
		configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User userLogin(String email, String password) {
		
		Query query = session.createQuery("select id, name, password from in.arunangshu.model.User where email=:useremail");
		
		query.setParameter("useremail", email);	
		
		List<Object[]> result = query.list();
		
		User user =null;
		
		System.out.println(result.toString());
		
		if (result != null && !result.isEmpty()) { 
		    Object[] row = (Object[]) result.get(0); 
		    Integer id = (Integer) row[0];
		    String retrievedPassword = (String) row[2];
		    String name=(String) row[1];

		    if (retrievedPassword.equals(password)) {
		        user = new User();
		        user.setEmail(email);
		        user.setId(id);
		        user.setName(name);
		        user.setPassword(null); 
		    }
		}
		
		return user;
	}

	@Override
	public User userSignUp(String name, String email, String password) {
		User user =null;
		try {
			Transaction transaction = session.beginTransaction();
			user = new User();
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
			session.save(user);
			transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			user=null;
		}
		return user;
	}

}

