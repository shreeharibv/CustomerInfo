package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query(value ="UPDATE customer c SET c.phone_number = :phoneNumber WHERE c.id = :id",nativeQuery = true)
    void updateCustomerByPhoneNumber(@Param("phoneNumber") Long phoneNumber, @Param("id")Long id);

    @Transactional
    @Modifying
    @Query(value ="UPDATE customer c SET c.customer_address = :customerAddress WHERE c.id = :id",nativeQuery = true)
    void updateCustomerByAddress(@Param("id") Long id, @Param("customerAddress")String customerAddress);
}
