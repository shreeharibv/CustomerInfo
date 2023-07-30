package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE customer c SET c.phone_number = :phoneNumber WHERE c.id = :id", nativeQuery = true)
    void updateCustomerByPhoneNumber(@Param("phoneNumber") Long phoneNumber, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer c SET c.customer_address = :customerAddress WHERE c.id = :id", nativeQuery = true)
    void updateCustomerByAddress(@Param("id") Long id, @Param("customerAddress") String customerAddress);

    @Query(value = "SELECT bank_Name FROM customer WHERE id = :customerId", nativeQuery = true)
    String getBankNameOfCustomer(@Param("customerId") int customerId);

    @Query(value = "SELECT amount FROM Customer WHERE account_Number = :accountNumber", nativeQuery = true)
    double getBalance(@Param("accountNumber") Long accountNumber);

    @Query(value = "SELECT amount FROM Customer WHERE phone_Number = :phoneNumber", nativeQuery = true)
    double getBalanceByPhoneNumber(@Param("phoneNumber") Long phoneNumber);
}
