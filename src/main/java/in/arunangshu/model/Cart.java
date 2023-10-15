package in.arunangshu.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CartID id;
	private Integer qty;
	public CartID getId() {
		return id;
	}
	public void setId(CartID id) {
		this.id = id;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", qty=" + qty + "]";
	}
	public Cart(CartID id, Integer qty) {
		super();
		this.id = id;
		this.qty = qty;
	}
	public Cart() {
		super();
	}
	
	
}
