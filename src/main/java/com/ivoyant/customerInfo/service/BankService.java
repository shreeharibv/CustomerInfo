package com.ivoyant.customerInfo.service;
import com.ivoyant.customerInfo.entity.Bank;

import java.util.List;
public interface BankService {
    Bank createBank(Bank bank);
    List<Bank> getAllBanks();

}

