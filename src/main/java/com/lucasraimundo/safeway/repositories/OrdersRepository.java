package com.lucasraimundo.safeway.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lucasraimundo.safeway.entities.Orders;
import com.lucasraimundo.safeway.entities.Usuario;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	@Transactional(readOnly=true)
	Page<Orders> findByUsuario(Usuario usuario, Pageable pageRequest);

}
