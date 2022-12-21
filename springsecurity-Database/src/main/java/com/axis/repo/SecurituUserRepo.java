package com.axis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.axis.modal.SecureUser;


public interface SecurituUserRepo extends  JpaRepository<SecureUser, Long>{

	
	@Query(value = "select * from securityuser where user_name =?1", nativeQuery = true)
	SecureUser findByEmail(String email);

}
