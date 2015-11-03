package day_4_shop_objects;

import java.util.Date;

public class Sales {
	
	private Customer customer;
	private Goods goods;
	private Date date;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return getDate().getTime() + " " + getGoods() + " " + getCustomer();
	}


}
