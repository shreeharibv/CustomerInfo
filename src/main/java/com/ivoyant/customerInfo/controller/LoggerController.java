package com.ivoyant.customerInfo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ivoyant.customerInfo.entity.Logger;
import com.ivoyant.customerInfo.service.implementation.LoggerService;

@RestController
public class LoggerController {
    @Autowired
    static
    LoggerService loggerService = new LoggerService();

    // addLog
    public static void addLog(Logger logger) {
        loggerService.addLog(logger);
    }

    // showLog
    @GetMapping("/account/{acctID}/logs")
    public Logger showLog(@PathVariable Long acctNumber) {
        return loggerService.showLog(acctNumber);
    }

    public void deleteLog(Long acctNumber) {
        loggerService.deleteLog(acctNumber);
    }
}
