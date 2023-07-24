package com.ivoyant.customerInfo.service;

import com.ivoyant.customerInfo.entity.Bank;
import com.ivoyant.customerInfo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public void createBank(Bank bank) {
        try {
            bankRepository.save(bank);
        } catch(Exception e) {
            e.printStackTrace();
            }

    }

    public List<Bank> getAllBanks() {
        return bankRepository.getAllBanks();
    }

    public List<Bank> getBanksByBankaddress(String bankAddress) {
        return bankRepository.getBanksByLocation(bankAddress);
    }
}
