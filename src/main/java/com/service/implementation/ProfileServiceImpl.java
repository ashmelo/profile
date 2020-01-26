package com.service.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.beans.LoginRequest;
import com.beans.TokenResponse;
import com.beans.UserRequest;
import com.beans.UserResponse;
import com.domain.UserProfile;
import com.parameter.ApplicationParameter;
import com.repository.ProfileRepository;
import com.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ApplicationParameter applicationParameter;

    @Autowired
    RestTemplate restTemplate;

    public void registerUser(UserRequest profileRequest){
        UserProfile profile = UserProfile.builder()
                .phoneNumber(profileRequest.getPhoneNumber())
                .pincode(profileRequest.getPincode())
                .identityProofType(profileRequest.getIdentityProofType())
                .identityProof(profileRequest.getIdentityProof())
                .firstName(profileRequest.getFirstName())
                .lastName(profileRequest.getLastName())
                .country(profileRequest.getCountry())
                .city(profileRequest.getCity())
                .address1(profileRequest.getAddress1())
                .address2(profileRequest.getAddress2())
                .state(profileRequest.getState())
                .password(profileRequest.getPassword()).build();
        profileRepository.saveAndFlush(profile);
    }

    @Override
    public TokenResponse generateUserToken(LoginRequest request) {
        UserProfile profile = profileRepository.findByIdentityProofAndPassword(request.getUserId(),request.getPassword());
        Algorithm algorithm = Algorithm.HMAC256("tokenSecret");
        String token = JWT.create()
                .withClaim("id", profile.getId())
                .withClaim("password", profile.getPassword())
                .withClaim("identityProof", profile.getIdentityProof())
                .sign(algorithm);
        return TokenResponse.builder().token(token).build();
    }

    @Override
    public TokenResponse genratePoliceToken(LoginRequest request) {
        String url = applicationParameter.getPoliceTokenUrl() + "?login=" + request.getUserId() + "&password=" + request.getPassword();
        TokenResponse tokenResponse = new TokenResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity = new HttpEntity(null, headers);
        try {
            ResponseEntity<TokenResponse> re = restTemplate.exchange(url, HttpMethod.GET, requestEntity, TokenResponse.class);
            tokenResponse = re.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenResponse;
    }

    @Override
    public UserResponse getUserDetails(String userId) {
        UserProfile userProfile = profileRepository.findByIdentityProof(userId);
        UserResponse response= UserResponse.builder()
                .userId(userProfile.getIdentityProof())
                .password(userProfile.getPassword()).build();
        return response;
    }
}
