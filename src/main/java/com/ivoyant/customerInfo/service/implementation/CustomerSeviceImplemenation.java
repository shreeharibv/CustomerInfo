package com.ivoyant.customerInfo.service.implementation;

import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.service.CustomerService;
import com.ivoyant.customerInfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSeviceImplemenation implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerSeviceImplemenation.class);
    @Override
    public Customer createCustomer(Customer customer) {
        try {
            logger.info("Sucessfully inserted data for name {} ", customer.getCustomerName());
            return customerRepository.save(customer);
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }

        return null;
    }

    @Override
    public Customer getCustomerById(Long CustomerId) {
        try {
            Optional<Customer> optionalCustomer= customerRepository.findById(CustomerId);
            logger.info("Sucessfully fetched data for Customer ID {}", CustomerId);
            return optionalCustomer.get();
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            logger.info("Sucessfully fetched all the data from Customer ");
            return customerRepository.findAll();
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            Customer existingCustomer = customerRepository.findById(customer.getId()).get();
            existingCustomer.setCustomerName(customer.getCustomerName());
            existingCustomer.setCustomerAddress(customer.getCustomerAddress());
            existingCustomer.setAge(customer.getAge());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            existingCustomer.setAadhar(customer.getAadhar());
            existingCustomer.setPAN(customer.getPAN());
            existingCustomer.setAccountNumber(customer.getAccountNumber());
            existingCustomer.setAccountType(customer.getAccountType());
            existingCustomer.setAmount(customer.getAmount());
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            logger.info("Updated data for employee {}", customer.getCustomerName());
            return updatedCustomer;

        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }
        return null;
    }

    @Override
    public double getBalance(Long AccountNumber) {
        try {
            logger.info("Sucessfully fetched the Balance  for Customer Account Number{}",AccountNumber);
            return customerRepository.findBalanceByAcctID(AccountNumber);
            //customerRepository.findBy()
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }

        return 0;
    }


    @Override
    public void deleteCustomer(Long customerId) {
        try {
            customerRepository.deleteById(customerId);
            logger.info("Sucessfully Deleted data for Customer ID {}", customerId);
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }

    }

    @Override
    public void depositAmount(Long AccountNumber, double amount) {
        try {
            customerRepository.saveBalanceByAcctID(AccountNumber, amount);
            logger.info("Successfully Deposited the Amount of RS {} for the Account Number {}",amount,AccountNumber);
        }catch (Exception e){
            logger.error("Exception Occurred",e.getMessage());
        }

    }

    @Override
    public void withdrawAmount(Long AccountNumber, double amount) {
        try {
            customerRepository.withdrawAmountByAcctID(AccountNumber, amount);
            logger.info("Successfully WithDrawed  the Amount of RS {} from the Account Number {}",amount,AccountNumber);
        }catch (Exception e){
            logger.error("Exception Occurred",e.getMessage());
        }




    }

    @Override
    public void transferAmount(Long  sourceAcctNumber, Long  destAcctNumber, double amount) {
        try{
            customerRepository.withdrawAmountByAcctID(sourceAcctNumber, amount);
            customerRepository.saveBalanceByAcctID(destAcctNumber, amount);
            logger.info("Successfully Transfered the Amount of RS {} from the Account Number {} to the Account Number{}",
                    amount,sourceAcctNumber,destAcctNumber);
        }catch (Exception e){
            logger.error("Exception Occurred",e.getMessage());
        }



    }

    @Override
    public double getBalanceByPhoneNumber(Long phoneNumber) {
        try {
            logger.info("Sucessfully fetched the Balance  for Customer Phone Number{}",phoneNumber);
            return customerRepository.findBalanceByPhoneNumber(phoneNumber);
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }
        return 0;
    }


}
