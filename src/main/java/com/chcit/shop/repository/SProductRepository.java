package com.chcit.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.chcit.shop.model.SProduct;

@Repository
public interface SProductRepository extends JpaRepository<SProduct, Integer>  {

}
