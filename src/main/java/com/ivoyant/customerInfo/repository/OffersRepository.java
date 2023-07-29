package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Bank;
import com.ivoyant.customerInfo.entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OffersRepository extends JpaRepository<Offers,Long> {
    @Query(value = "SELECT * FROM offers WHERE bank_Name = :bankName", nativeQuery = true)
    List<Offers> getOffersByName(@Param("bankName") String bankAddress);
}
