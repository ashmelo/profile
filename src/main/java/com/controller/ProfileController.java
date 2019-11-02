package com.controller;

import com.domain.UserProfile;
import com.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile/api/v1")
@Api(value = "Register User", description = "Profile Controller")
@AllArgsConstructor
public class ProfileController {

    ProfileService profileService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Register a new user")
    public ResponseEntity registerUser(@RequestBody UserProfile profile) {
        profileService.registerUser(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
