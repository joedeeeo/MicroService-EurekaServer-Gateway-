package com.bloodbank.service_donor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.service_donor.domain.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, String>{
	Optional<Donor> findByUsername(String username);
}
