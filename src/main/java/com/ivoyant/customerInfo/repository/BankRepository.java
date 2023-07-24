package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankRepository extends JpaRepository<Bank, Long> {
    @Query("select * from Banks where bankAddress = ?1")
    public Bank getBanksByBankaddress(String bankAddress);
}
