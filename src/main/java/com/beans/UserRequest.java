package com.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

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
    private String identityProof;
    private String password;
}
