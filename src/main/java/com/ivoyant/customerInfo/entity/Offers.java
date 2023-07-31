package com.ivoyant.customerInfo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.Set;

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
    @JoinTable(name = "OffersById",joinColumns = @JoinColumn(name= "offer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bank_name", referencedColumnName = "bank_name"))
    private Set<Role> bankset;


}
