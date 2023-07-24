package com.ivoyant.customerInfo.service;

import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void getCustomerById(Long customerId) {
        customerRepository.getById(customerId);
    }
}
