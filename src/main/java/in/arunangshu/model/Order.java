package in.arunangshu.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;
	private CartID id;
	private Integer qty;
	@CreationTimestamp
	private LocalDateTime creationdate;
	public Order() {
		super();
	}
	public Order(CartID id, Integer qty, LocalDateTime creationdate) {
		super();
		this.id = id;
		this.qty = qty;
		this.creationdate = creationdate;
	}
	public Order(Integer oid, CartID id, Integer qty, LocalDateTime creationdate) {
		super();
		this.oid = oid;
		this.id = id;
		this.qty = qty;
		this.creationdate = creationdate;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
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
	public LocalDateTime getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(LocalDateTime creationdate) {
		this.creationdate = creationdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", id=" + id + ", qty=" + qty + ", creationdate=" + creationdate + "]";
	}
}
