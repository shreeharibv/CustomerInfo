package com.ivoyant.customerInfo.repository;

import com.ivoyant.customerInfo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
