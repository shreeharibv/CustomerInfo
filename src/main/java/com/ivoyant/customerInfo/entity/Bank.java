package com.ivoyant.customerInfo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Builder
@Table(name = "Banks")

public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String bankName;
    @Column(nullable = false)
    private String bankBranch;
    @Column(nullable = false)
    private String bankAddress;
    @Column(nullable = false)
    private String IFSC;
    @Column(nullable = false, unique = true)
    private Long custAccountNumber;
}
