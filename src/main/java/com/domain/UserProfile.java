package com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private String identityProofType;

    @Column(unique = true)
    private String identityProof;

    private String password;
}
