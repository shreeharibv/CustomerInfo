package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query("SELECT b FROM Bank b")
    List<Bank> getAllBanks();

    @Query(value = "SELECT * FROM bank WHERE bank_Address = :bankAddress", nativeQuery = true)
    List<Bank> getBanksByLocation(@Param("bankAddress") String bankAddress);
}
