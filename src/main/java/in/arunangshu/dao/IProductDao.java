package in.arunangshu.dao;

import java.util.List;

import in.arunangshu.model.Product;

public interface IProductDao {
	public String uploadProduct(String name, String category, String price, byte[] image);
	public List<Product> getAllProduct();
}
