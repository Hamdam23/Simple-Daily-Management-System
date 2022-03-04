package net.guides.springboot.todomanagement.service;

import net.guides.springboot.todomanagement.model.Product;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IProductService {

	List<Product> getProductsByUser(String user);

	Optional<Product> getProductById(long id);

	void updateProduct(@Valid Product product);

	void addProduct(String name, String category, String description, String userName, Date timestamp);

	void deleteProduct(long id);
	
	void saveProduct(Product product);

}