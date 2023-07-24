package com.ivoyant.customerInfo.controller;
import com.ivoyant.customerInfo.entity.Bank;
import com.ivoyant.customerInfo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Banks/")
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("createBank")
    public ResponseEntity<String> createBank(@RequestBody Bank bank) {
        bankService.createBank(bank);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @GetMapping("allBanks")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }
    @GetMapping("getBanks/{bankAddress}")
    public ResponseEntity<List<Bank>> getBanksBy(@PathVariable("bankAddress") String bankAddress) {
       List<Bank> banks = bankService.getBanksByBankaddress(bankAddress);
        return new ResponseEntity<>(banks,HttpStatus.OK);
    }
}
