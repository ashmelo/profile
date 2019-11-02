package com.service.implementation;

import com.domain.UserProfile;
import com.repository.ProfileRepository;
import com.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public void registerUser(UserProfile profile){
        profileRepository.saveAndFlush(profile);
    }
}
