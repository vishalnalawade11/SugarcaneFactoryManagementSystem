package com.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByAadharNumber(String aadharNumber);

	User findByEmailAndPassword(String email, String password);

	User findByAadharNumberAndPassword(String aadharNumber, String password);
}
