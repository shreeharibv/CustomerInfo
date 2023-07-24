package com.ivoyant.customerInfo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonProperty("bankName")
    private String bankName;
    @Column
    @JsonProperty("bankBranch")
    private String bankBranch;
    @Column @JsonProperty("bankAddress")
    private String bankAddress;
    @Column @JsonProperty("ifsc")
    private String ifsc;
    @Column @JsonProperty("custAccountNumber")
    private Long custAccountNumber;
}
