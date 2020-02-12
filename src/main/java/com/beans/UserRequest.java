package com.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "firstName cannot be null")
    @NotEmpty(message = "firstName cannot be empty")
    private String firstName;
    private String lastName;
    @NotNull(message = "phoneNumber cannot be null")
    @NotEmpty(message = "phoneNumber cannot be empty")
    private long phoneNumber;
    @NotNull(message = "address1 cannot be null")
    @NotEmpty(message = "address1 cannot be empty")
    private String address1;
    private String address2;
    @NotNull(message = "city cannot be null")
    @NotEmpty(message = "city cannot be empty")
    private String city;
    @NotNull(message = "state cannot be null")
    @NotEmpty(message = "state cannot be empty")
    private String state;
    @NotNull(message = "country cannot be null")
    @NotEmpty(message = "country cannot be empty")
    private String country;
    @NotNull(message = "pincode cannot be null")
    @NotEmpty(message = "pincode cannot be empty")
    private int pincode;
    @NotNull(message = "identityProofType cannot be null")
    @NotEmpty(message = "identityProofType cannot be empty")
    private String identityProofType;
    @NotNull(message = "identityProof cannot be null")
    @NotEmpty(message = "identityProof cannot be empty")
    private String identityProof;
    @NotEmpty(message = "password cannot be empty")
    @NotNull(message = "password cannot be null")
    private String password;
}
