package org.jsp.userapp.repository;



import java.util.Optional;

import org.jsp.userapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.phone = ?1 and u.password = ?2")
	Optional<User> VerifyUser(long phone,String password);
	
	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	Optional<User> VerifyUser(String email,String password);
}
