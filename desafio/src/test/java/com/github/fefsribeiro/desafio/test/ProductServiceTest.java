package com.github.fefsribeiro.desafio.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.github.fefsribeiro.desafio.dto.ProductDto;
import com.github.fefsribeiro.desafio.dto.ProductFormDto;
import com.github.fefsribeiro.desafio.service.ProductService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = Replace.ANY)
class ProductServiceTest {
	
	@Autowired
	private ProductService service;
	
	@Test
	void ShouldCreateProductAndReturnProductWithId() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		ProductDto result = service.toSave(form);
		
		assertFalse(result.getId().isEmpty());
		assertEquals(result.getName(),"Roupa");
		assertEquals(result.getDescription(), "Camiseta");
		assertEquals(result.getPrice(),new BigDecimal ("50.00"));
	}
	
	@Test
	void ShouldReturnListOfProductsWithOneElement() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		service.toSave(form);
		
		List<ProductDto> listProducts = service.toList();
		
		assertTrue(listProducts.size()==1);
	}
	
	@Test
	void ShouldGetOneProductById() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		ProductDto result = service.toSave(form);
		
		Optional<ProductDto> resultUpdated =  service.toFindById(result.getId());
		
		assertFalse(resultUpdated.isEmpty());
		assertEquals(result.getId(), resultUpdated.get().getId());
		
	}
	
	
	@Test
	void ShouldUpdateProductAndReturnProductWithId() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		ProductDto result = service.toSave(form);
		
		ProductFormDto formUpdated = new ProductFormDto();
		formUpdated.setName("Roupa");
		formUpdated.setDescription("Blusa Frio");
		formUpdated.setPrice(new BigDecimal ("100.00"));
		
		Optional<ProductDto> dtoUpdated = service.toUpdateById(formUpdated, result.getId());
		
		assertFalse(dtoUpdated.isEmpty());
		assertEquals(dtoUpdated.get().getName(),"Roupa");
		assertEquals(dtoUpdated.get().getDescription(), "Blusa Frio");
		assertEquals(dtoUpdated.get().getPrice(),new BigDecimal ("100.00"));
		
	}
	
	@Test
	void ShouldDeleteProductById() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		ProductDto result = service.toSave(form);
		
		service.toDeleteById(result.getId());
		
		Optional<ProductDto> dto = service.toFindById(result.getId());
		
		assertTrue(dto.isEmpty());
	}
	
	@Test
	void ShouldReturnListOfProductWithOneElementBySearchParms() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		ProductDto result = service.toSave(form);
	
		List<ProductDto> listProducts = service.toListBySearch("Roupa", new BigDecimal("10.00"), new BigDecimal("60.00"));
		
		assertTrue(listProducts.size()==1);
		assertEquals(listProducts.get(0).getId(), result.getId());
	}
	
	@Test
	void ShouldReturnListOfProductWithZeroElementBySearchParms() {
		ProductFormDto form = new ProductFormDto();
		form.setName("Roupa");
		form.setDescription("Camiseta");
		form.setPrice(new BigDecimal ("50.00"));
		
		service.toSave(form);
	
		List<ProductDto> listProducts = service.toListBySearch("Casaco", new BigDecimal("60.00"), new BigDecimal("100.00"));
		
		assertTrue(listProducts.size()==0);
	}
}
