package com.lucasraimundo.safeway.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemOrderPK implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name="orders_id")
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name="products_id")
	private Product products;
	
	public Orders getOrder() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return products;
	}
	public void setProduct(Product product) {
		this.products = product;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orders, products);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrderPK other = (ItemOrderPK) obj;
		return Objects.equals(orders, other.orders) && Objects.equals(products, other.products);
	}
}
