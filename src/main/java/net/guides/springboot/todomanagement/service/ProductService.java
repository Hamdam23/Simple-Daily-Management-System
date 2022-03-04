package net.guides.springboot.todomanagement.service;

import net.guides.springboot.todomanagement.model.Product;
import net.guides.springboot.todomanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProductsByUser(String user) {
		return productRepository.findByUserName(user);
	}

	@Override
	public Optional<Product> getProductById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void addProduct(String name, String category, String description, String userName, Date timestamp) {
		productRepository.save(new Product(name, category, description, userName, timestamp));
	}

	@Override
	public void deleteProduct(long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.delete(product.get());
		}
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
}