package com.ivoyant.customerInfo.controller;

import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.entity.Offers;
import com.ivoyant.customerInfo.service.CustomerService;
import com.ivoyant.customerInfo.service.OffersService;
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
    @Autowired
    private OffersService offersService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("getCustomer/{id}")
    public ResponseEntity<String> getCustomerById(@PathVariable("id") Long customerId) {
        customerService.getCustomerById(customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("allCustomers")
    public ResponseEntity<?> getAllCustomers() {
        customerService.getAllCustomers();
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    //update Customers phone Number

    @PutMapping("updateCustomer/{phoneNumber}/{customerID}")
    public ResponseEntity<String> updateCustomer(@PathVariable("phoneNumber") Long phoneNumber,
                                                 @PathVariable("customerID") Long customerID) {
        customerService.updateCustomer(phoneNumber, customerID);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    //update customer's Address
    @PutMapping("updateCustomerAddress/{id}/{customerAddress}")
    public ResponseEntity<String> updateCustomerAddress(@PathVariable("id") Long id, @PathVariable("customerAddress") String customerAddress) {
        customerService.updateCustomerAddress(id, customerAddress);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("getAllOffers/{id}")
    public ResponseEntity<List<Offers>> getOffersByLocation(@PathVariable("id") int customerId) {
        String bankName = customerService.getBankNameOfCustomer(customerId);
        List<Offers> offers = offersService.getOffersByName(bankName);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    // checkBalance
    @GetMapping("{acctNumber}/balance")
    public double getBalance(@PathVariable Long acctNumber) {
        return customerService.getBalance(acctNumber);
    }

    // checkBalance
    @GetMapping("{phoneNumber}/balanceByPhoneNumber")
    public double getBalanceByPhoneNumber(@PathVariable Long phoneNumber) {
        return customerService.getBalanceByPhoneNumber(phoneNumber);
    }

    //deposit amount
    @PutMapping("{acctNumber}/deposit/{amount}")
    public void depositAmount(@PathVariable Long acctNumber, @PathVariable double amount) {
        double initBal = getBalance(acctNumber);
        double finalBal = initBal + amount;
        customerService.depositAmount(acctNumber, finalBal);
    }

    // withdrawAmount
    @PutMapping("{acctNumber}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable Long acctNumber, @PathVariable double amount) {
        double initBal = getBalance(acctNumber);
        double finalBal = initBal - amount;
        customerService.depositAmount(acctNumber, finalBal);
    }

    // transferAmount
    @PutMapping("{sourceAcctNumber}/transfer/{destAcctNumber}/{amount}")
    public void transferAmount(@PathVariable Long sourceAcctNumber, @PathVariable Long destAcctNumber, @PathVariable double amount) {
        double initBalSender = getBalance(sourceAcctNumber);
        double finalBalanceOfSender = initBalSender - amount;
        customerService.depositAmount(sourceAcctNumber, finalBalanceOfSender);
        double initBalReceiver = getBalance(destAcctNumber);
        double finalBalanceOfReciever = initBalReceiver + amount;
        customerService.depositAmount(destAcctNumber, finalBalanceOfReciever);
    }
}
