package com.ivoyant.customerInfo.controller;
import com.ivoyant.customerInfo.entity.Bank;
import com.ivoyant.customerInfo.repository.BankRepository;
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
    private BankRepository bankRepository;
    @PostMapping("createBank")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank savedBank = bankService.createBank(bank);
        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
    }
    @GetMapping("allBanks")
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }
    @GetMapping("getBanks/{bankAddress}")
    public ResponseEntity<Bank> getBanksBy(@PathVariable("bankAddress") String bankAddress) {
        Bank banks = bankRepository.getBanksByBankaddress(bankAddress);
        return new ResponseEntity<>(banks,HttpStatus.OK);
    }
}
