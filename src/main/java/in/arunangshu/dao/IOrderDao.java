package in.arunangshu.dao;

import java.util.List;

import in.arunangshu.model.OrderOutput;
import in.arunangshu.model.cartOutput;

public interface IOrderDao {
	public void addOrder(int userId,int prodId,int qnt);
	public void deleteOrder(int id);
	public List<OrderOutput> showOrder(int userId);
}
