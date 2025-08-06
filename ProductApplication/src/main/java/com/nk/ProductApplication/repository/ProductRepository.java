package com.nk.ProductApplication.repository;

import com.nk.ProductApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
