package com.ivoyant.customerInfo.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@Builder
/*@AllArgsConstructor
@NoArgsConstructor*/
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private int age;
    private Long phoneNumber;
    private Long Aadhar;
    private String PAN;
    private Long AccountNumber;
    private String AccountType;
    private double Amount;
}
