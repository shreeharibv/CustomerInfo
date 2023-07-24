package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select Amount from customers where AccountNumber = :acctNumber")
    public double findBalanceByAcctID(@Param( "acctNumber") Long acctNumber);
    @Query("select Amount from customers where phoneNumber = :phoneNumber")
    public double findBalanceByPhoneNumber(@Param("phoneNumber") Long phoneNumber);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update customers set Amount  = :Amount where AccountNumber=:AccountNumber")
    public void saveBalanceByAcctID(@Param("AccountNumber") Long AccountNumber, @Param("Amount") double Amount);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update customers set Amount = :Amount where AccountNumber= :AccountNumber")
    public void withdrawAmountByAcctID(@Param("AccountNumber") Long AccountNumber, @Param("Amount") double Amount);

}
