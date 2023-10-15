package in.arunangshu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CartID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer uid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setProjId(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "CartID [pid=" + pid + ", uid=" + uid + "]";
	}
	public CartID(Integer pid, Integer uid) {
		super();
		this.pid = pid;
		this.uid = uid;
	}
	public CartID() {
		super();
	}
	
	
}
