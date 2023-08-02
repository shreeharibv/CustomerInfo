package com.ivoyant.customerInfo.service;

import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return customer;
    }

    public void getCustomerById(Long customerId) {
        try {
            customerRepository.getById(customerId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateCustomer(Long phoneNumber, Long customerID) {
        try {
            customerRepository.updateCustomerByPhoneNumber(phoneNumber, customerID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    public void updateCustomerAddress(Long id, String customerAddress) {
        try {
            customerRepository.updateCustomerByAddress(id, customerAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Long customerId) {
        try {
            customerRepository.deleteById(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBankNameOfCustomer(int customerId) {
        try {
            return customerRepository.getBankNameOfCustomer(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public double getBalance(Long acctNumber) {
        try {
            return customerRepository.getBalance(acctNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getBalanceByPhoneNumber(Long phoneNumber) {
        try {
            return customerRepository.getBalanceByPhoneNumber(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public void depositAmount(Long acctNumber, double finalBal) {
        try{
            customerRepository.depositAmount(acctNumber,finalBal);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
