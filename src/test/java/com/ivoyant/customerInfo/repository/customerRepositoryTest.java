/*
package com.ivoyant.customerInfo.repository;
import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.service.CustomerService;
import com.ivoyant.customerInfo.repository.CustomerRepository;
import lombok.Builder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@SpringBootTest
public class customerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Test
    @Order(1)
    @Rollback
    public void saveCustomerTest() {

        Customer customer = Customer.builder()
                .customerName("Sampada")
                .customerAddress( "Davanagere")
                .age( 20)
                .phoneNumber(1234987665L)
                .AccountNumber(9876576991L)
                .PAN("ABCDE9837F")
                .Amount(10000.50)
                .AccountType("Savings")
                .Aadhar(12341234567890L)
                .build();

        customerService.createCustomer(customer);

        Assertions.assertThat(customer.getId()).isGreaterThan(0);

    }
}
*/
