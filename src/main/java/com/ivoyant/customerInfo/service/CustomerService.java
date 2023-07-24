package com.ivoyant.customerInfo.service;
import com.ivoyant.customerInfo.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long CustomerId);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    double getBalance(Long  AccountNumber);
    void deleteCustomer(Long customerId);
    void depositAmount(Long AccountNumber, double amount);
    void withdrawAmount(Long AccountNumber, double amount);
    void transferAmount(Long sourceAcctNumber, Long destAcctNumber,double amount);
     double getBalanceByPhoneNumber(Long phoneNumber);
}
