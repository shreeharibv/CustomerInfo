package com.ivoyant.customerInfo.controller;

import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.entity.Logger;
import com.ivoyant.customerInfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Customers/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //update Customers phone Number

    @PutMapping("updateCustomer/{phoneNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("phoneNumber") Long phoneNumber,
                                                   @RequestBody Customer customer) {
       customer.setPhoneNumber(phoneNumber);
        Customer updatedCustomer= customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    //update customer's Address
    @PutMapping("updateCustomer/{customerAddress}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerAddress") String customerAddress,
                                                   @RequestBody Customer customer) {
        customer.setCustomerAddress(customerAddress);
        Customer updatedCustomer= customerService.updateCustomer(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    // checkBalance
    @GetMapping("{acctNumber}/balance")
    public double getBalance(@PathVariable Long acctNumber) {
        return customerService.getBalance(acctNumber);
    }
    // checkBalance
    @GetMapping("{phoneNumber}/balance")
    public double getBalanceByPhoneNumber(@PathVariable Long phoneNumber) {
        return customerService.getBalanceByPhoneNumber(phoneNumber);
    }
    //deposit amount
    @PutMapping("{acctNumber}/deposit/{amount}")
    public void depositAmount(@PathVariable Long acctNumber, @PathVariable double amount) {
        double initBal = getBalance(acctNumber);
        customerService.depositAmount(acctNumber, amount);
        Logger logger = new Logger(acctNumber, "Deposited", "Success", initBal, initBal + amount);
        LoggerController.addLog(logger);

    }
    // withdrawAmount
    @PutMapping("{acctNumber}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable Long acctNumber, @PathVariable double amount) {
        double initBal = getBalance(acctNumber);
        customerService.withdrawAmount(acctNumber, amount);
        Logger logger = new Logger(acctNumber, "Withdrawn", "Success", initBal, initBal - amount);
        LoggerController.addLog(logger);
    }
    // transferAmount
    @PutMapping("{sourceAcctNumber}/transfer/{destAcctNumber}/{amount}")
    public void transferAmount(@PathVariable Long sourceAcctNumber, @PathVariable Long destAcctNumber, @PathVariable double amount) {
        double initBalSender = getBalance(sourceAcctNumber);
        double initBalReceiver = getBalance(destAcctNumber);
        customerService.transferAmount(sourceAcctNumber, destAcctNumber, amount);
        Logger loggerSender = new Logger(sourceAcctNumber, "Transferred", "Success", initBalSender, initBalSender - amount);
        LoggerController.addLog(loggerSender);
        Logger loggerReceiver = new Logger(destAcctNumber, "Received", "Success", initBalReceiver,
                initBalReceiver + amount);
        LoggerController.addLog(loggerReceiver);
    }





}
