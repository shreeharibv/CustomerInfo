package com.ivoyant.customerInfo.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Builder
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerAddress;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false, unique = true)
    private Long phoneNumber;
    @Column(nullable = false, unique = true)
    private Long Aadhar;
    @Column(nullable = false, unique = true)
    private String PAN;
    @Column(nullable = false, unique = true)
    private Long AccountNumber;
    @Column(nullable = false)
    private String AccountType;
    @Column(nullable = false)
    private double Amount;

}
