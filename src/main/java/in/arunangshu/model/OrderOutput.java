package in.arunangshu.model;

import java.time.LocalDateTime;

public class OrderOutput {
	private Integer id;
	private String name;
	private String category;
	private Integer price;
	private Integer qty;
	private LocalDateTime creationdate;
	public LocalDateTime getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "cartOutput [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", qty="
				+ qty + "]";
	}
	public OrderOutput(Integer id, String name, String category, Integer price, Integer qty) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.qty = qty;
	}
	public OrderOutput() {
		super();
	}
}
