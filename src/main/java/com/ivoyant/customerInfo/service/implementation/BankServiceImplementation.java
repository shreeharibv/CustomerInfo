package com.ivoyant.customerInfo.service.implementation;
import com.ivoyant.customerInfo.entity.Bank;
import com.ivoyant.customerInfo.entity.Customer;
import com.ivoyant.customerInfo.repository.BankRepository;
import com.ivoyant.customerInfo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImplementation implements BankService {
    @Autowired
    static
    BankRepository bankRepository;
    private static final Logger logger = LoggerFactory.getLogger(BankServiceImplementation.class);
    @Override
    public  Bank createBank(Bank bank) {
            try {
                logger.info("Sucessfully inserted data for name {} ", bank.getBankName());
                return bankRepository.save(bank);
            } catch (Exception e) {
                logger.error("Exception occurred{}", e.getMessage());
            }
        return null;
    }

    @Override
    public List<Bank> getAllBanks() {
        try {
            logger.info("Sucessfully fetched all the Banks data from Bank ");
            return bankRepository.findAll();
        } catch (Exception e) {
            logger.error("Exception occurred{}", e.getMessage());
        }
        return null;
    }
}
