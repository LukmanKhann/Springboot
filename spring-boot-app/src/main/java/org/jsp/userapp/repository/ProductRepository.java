package org.jsp.userapp.repository;

import java.util.List;

import org.jsp.userapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.users.id=?1")
	List<Product> findProductByUserId(int uid);
}
