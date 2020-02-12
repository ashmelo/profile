package com.service;

import com.beans.LoginRequest;
import com.beans.TokenResponse;
import com.beans.UserRequest;
import com.beans.UserResponse;
import com.domain.UserProfile;

public interface ProfileService {

    void registerUser(UserRequest userRequest);

    TokenResponse generateUserToken(LoginRequest request);

    TokenResponse genratePoliceToken(LoginRequest request);

    UserResponse getUserDetails(String userId);

}
