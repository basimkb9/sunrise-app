package com.sunrise.sunriseapp.repository;

import com.sunrise.sunriseapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
