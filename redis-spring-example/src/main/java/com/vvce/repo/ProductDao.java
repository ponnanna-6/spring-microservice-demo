package com.vvce.repo;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.vvce.entity.Product;

@Repository
public class ProductDao {
	private RedisTemplate template;
	public static final String HASH_KEY="Product";
	
	public Product save(Product product ) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}
	
	public List<Product> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Product getProductById(int id) {
		return (Product) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "PRODUCT DELETED!!";
	}
	
}
