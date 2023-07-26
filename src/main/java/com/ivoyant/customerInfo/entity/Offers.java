package com.ivoyant.customerInfo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name = "Offers")

public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String offerCategory;
    @Column(nullable = false)
    private String offerDescription;
    @Column(nullable = false)
    private int offerValidity;
    @Column(nullable = false)
    private String bankName;
}
