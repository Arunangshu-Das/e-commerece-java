package in.arunangshu.dao;

import java.util.List;

import in.arunangshu.model.Cart;
import in.arunangshu.model.cartOutput;

public interface ICartDao {
	public Cart addCart(int userId,int prodId);
	public Integer incCart(int UserId, int prodId);
	public Integer decCart(int UserId, int prodId);
	public List<cartOutput> showCart(int userId);
	public void deleteCart(int userId,int prodId);
	public void checkout(int userId);
}
