package com.lucasraimundo.safeway.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instant; 
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "id.orders")
	private Set<ItemOrder> items= new HashSet<>();
	
public Orders() {
		
	}

	public Orders(Integer id, Date instant,  Usuario usuario) {
		super();
		this.id = id;
		this.instant = instant;
		this.usuario = usuario;
		
	}
	
	public double getTotalValue() {
		double som =0;
		for (ItemOrder ip : items) {
			som = som + ip.getSubTotal();
		}
		
		return som;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemOrder> getItems() {
		return items;
	}

	public void setItems(Set<ItemOrder> items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		builder.append("Pedido numero: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstant()));
		builder.append(", Cliente: ");
		builder.append(getUsuario().getName());
		builder.append("\nDetalhes:\n");
		for(ItemOrder ip : getItems()) {
			builder.append(ip.toString());
		}
		
		builder.append("Valor total:");
		builder.append(nf.format(getTotalValue()));
		
		return builder.toString();
	}

}
