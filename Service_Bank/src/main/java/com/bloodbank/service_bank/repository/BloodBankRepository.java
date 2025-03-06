package com.bloodbank.service_bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.service_bank.domian.BloodGroup;
import com.bloodbank.service_bank.enums.BloodType;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodGroup, BloodType>{

}
