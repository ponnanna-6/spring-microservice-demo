package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvce.entity.Product;
import com.vvce.repo.ProductDao;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class RedisSpringExampleApplication {
	
	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringExampleApplication.class, args);
	}

}
