package com.repository;

import com.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProfileRepository extends JpaRepository<UserProfile, Integer> {


    UserProfile findByIdentityProofAndPassword(String userId, String password);

    UserProfile findByIdentityProof(String userId);
}
