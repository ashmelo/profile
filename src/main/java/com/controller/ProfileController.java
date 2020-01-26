package com.controller;

import com.beans.LoginRequest;
import com.beans.TokenResponse;
import com.beans.UserRequest;
import com.beans.UserResponse;
import com.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile/api/v1")
@Api(value = "Register User", description = "Profile Controller")
@AllArgsConstructor
public class ProfileController {

    ProfileService profileService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Register a new user")
    public ResponseEntity registerUser(@RequestBody UserRequest profileRequest) {
        profileService.registerUser(profileRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/user_login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User login")
    public ResponseEntity<TokenResponse> loginUser(@RequestBody LoginRequest request) {
        return new ResponseEntity(profileService.generateUserToken(request), HttpStatus.OK);
    }

    @PostMapping(value = "/police_login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Police login")
    public ResponseEntity<TokenResponse> loginPolice(@RequestBody LoginRequest request) {
        return new ResponseEntity(profileService.genratePoliceToken(request), HttpStatus.OK);
    }

    @PostMapping(value = "/get_user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Police login")
    public ResponseEntity<UserResponse> getUserDetails(@RequestParam("userId") String userId) {
        return new ResponseEntity(profileService.getUserDetails(userId), HttpStatus.OK);
    }

}
