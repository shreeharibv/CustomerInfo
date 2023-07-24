package com.ivoyant.customerInfo.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ivoyant.customerInfo.repository.LoggerRepository;
import com.ivoyant.customerInfo.entity.Logger;
@Service

public  class LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    public void addLog(Logger logger) {
        loggerRepository.save(logger);
    }

    public Logger showLog(Long acctNumber) {
        return loggerRepository.findById(acctNumber.compareTo(acctNumber)).orElse(null);
    }

    public void deleteLog(Long acctNumber) {
        loggerRepository.deleteById(acctNumber.compareTo(acctNumber));
    }
}

