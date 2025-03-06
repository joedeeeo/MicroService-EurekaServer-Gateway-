package com.bloodbank.service_admin.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.service_admin.domain.Admin;

import jakarta.transaction.Transactional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	Optional<Admin> findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}
