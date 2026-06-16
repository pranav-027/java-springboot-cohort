package com.codingshuttle.prav.module3JpaTut.repository;

import com.codingshuttle.prav.module3JpaTut.entity.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	//Sorting by OrderBy
	List<Product> findAllByOrderByPriceAsc();
	List<Product> findAllByOrderByPriceDesc();

	//SortingBy using Sort param

	List<Product> findBy(Sort sort);

	List<Product> findByTitle(String title);

	List<Product> getTop2BySku(String sku);

	List<Product> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

	// SQL: WHERE sku IN (...)
	List<Product> findBySkuIn(List<String> skus);

	List<Product> findByTitleContaining(String prefix);
	//StartingWith, EndingWith and Containing seems like extension of Like
	Optional<Product> getByTitleAndPrice(String title, BigDecimal price);

	@Query("SELECT e FROM Product e where e.title = :title and e.price = :price")
	Optional<Product> findByTitleAndPrice(String title, BigDecimal price);

	List<Product> findAllOrderByPrice(BigDecimal price);

}
