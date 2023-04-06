package com.lucasraimundo.safeway.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasraimundo.safeway.entities.ItemOrder;
import com.lucasraimundo.safeway.entities.Orders;
import com.lucasraimundo.safeway.repositories.ItemOrderRepository;
import com.lucasraimundo.safeway.repositories.OrdersRepository;
import com.lucasraimundo.safeway.services.exceptions.ObjectNotFoundException;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public Orders find(Integer id) {
		Optional<Orders> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Orders.class.getName()));
	}
	
	@Transactional
	public Orders insert(Orders obj) {
		obj.setId(null);
		obj.setInstant(new Date());
		obj.setUsuario(usuarioService.find(obj.getUsuario().getId()));
		
		obj = repo.save(obj);
		
		for(ItemOrder ip : obj.getItems()) {
			ip.setDiscount(0.0);
			ip.setProduct(productService.find(ip.getProduct().getId()));
			ip.setPrice(ip.getProduct().getPrice());
			ip.setPrice(productService.find(ip.getProduct().getId()).getPrice());
			ip.setOrders(obj);
		}
		itemOrderRepository.saveAll(obj.getItems());
		
		
		return obj;
	}

}
