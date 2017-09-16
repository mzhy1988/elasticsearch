package com.chcit.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chcit.shop.model.SCart;



@Repository
public interface SCartRepository extends JpaRepository<SCart, Integer>  {

}
