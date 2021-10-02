package com.github.fefsribeiro.desafio.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.fefsribeiro.desafio.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p WHERE p.description LIKE %:q% OR p.name LIKE %:q% AND p.price BETWEEN :minPrice AND :maxPrice")
	List<Product> findProductByNameOrDescriptionAndMinAndMaxPrice(@Param("q") String q,
																  @Param("minPrice") BigDecimal minPrice, 
																  @Param("maxPrice") BigDecimal maxPrice);
}
