package com.ivoyant.customerInfo.entity;
import jakarta.persistence.*;

@Entity
public class Logger {
    //	@EmbeddedId
//	private LoggerPk id;
    @Id
    private Long acctNumber;
    private String transacType;
    private String transacStatus;
    private double initBal;
    private double finalBal;

    public Logger() {

    }

    public Logger(Long acctNumber, String transacType, String transacStatus, double initBal, double finalBal) {
        super();
        this.acctNumber = acctNumber;
        this.transacType = transacType;
        this.transacStatus = transacStatus;
        this.initBal = initBal;
        this.finalBal = finalBal;
    }

    public Long getAcctID() {
        return acctNumber;
    }

    public void setAcctID(Long acctNumber) {
        this.acctNumber = acctNumber;
    }

    public String getTransacType() {
        return transacType;
    }

    public void setTransacType(String transacType) {
        this.transacType = transacType;
    }

    public String getTransacStatus() {
        return transacStatus;
    }

    public void setTransacStatus(String transacStatus) {
        this.transacStatus = transacStatus;
    }

    public double getInitBal() {
        return initBal;
    }

    public void setInitBal(double initBal) {
        this.initBal = initBal;
    }

    public double getFinalBal() {
        return finalBal;
    }

    public void setFinalBal(double finalBal) {
        this.finalBal = finalBal;
    }

}
