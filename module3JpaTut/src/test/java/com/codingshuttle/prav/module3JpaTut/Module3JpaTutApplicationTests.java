package com.codingshuttle.prav.module3JpaTut;

import com.codingshuttle.prav.module3JpaTut.entity.Product;
import com.codingshuttle.prav.module3JpaTut.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Module3JpaTutApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {

		Product product = Product.builder()
				.sku("A001")
				.title("Product 1")
				.price(new BigDecimal("10.00"))
				.quantity(12)
				.build();
		Product savedProduct = productRepository.save(product);

		System.out.println(savedProduct);
	}

	@Test
	void getInfo(){
		List<Product> products = productRepository.findAll();
		for(Product product : products){
			System.out.println(product);
		}
	}

	@Test
	void findByTitle(){
		List<Product> products = productRepository.findByTitle("USB-C Hub");
		System.out.println(products);
	}

	@Test
	void getByTitleAndPrice(){
		Optional<Product> product = productRepository.getByTitleAndPrice("USB-C Hub", BigDecimal.valueOf(1299.50));
		product.ifPresent(System.out::println);
	}

	@Test
	void getrepo(){
		productRepository.findByTitleAndPrice("USB-C Hub", BigDecimal.valueOf(1299.50)).ifPresent(System.out::println);
	}


}
