package com.lucasraimundo.safeway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasraimundo.safeway.entities.ItemOrder;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Integer> {

}
