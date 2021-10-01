package com.github.fefsribeiro.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.fefsribeiro.desafio.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
