package com.codingshuttle.prav.module3JpaTut.controller;


import com.codingshuttle.prav.module3JpaTut.entity.Product;
import com.codingshuttle.prav.module3JpaTut.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@GetMapping
	public List<Product> findAll(@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(defaultValue = "5") Integer pageSize) {
//		return productRepository.findAll(Sort.by(Sort.Order.asc(sortBy),
//				  Sort.Order.desc("price"))); // multiple fieds can be added in this by( function to sort tied objects

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Direction.ASC, sortBy));

		Page<Product> page = productRepository.findAll(pageable);

		return page.getContent();

	}


}
