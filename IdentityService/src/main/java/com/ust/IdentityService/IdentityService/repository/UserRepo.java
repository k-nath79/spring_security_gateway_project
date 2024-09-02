package com.ust.IdentityService.IdentityService.repository;

import com.ust.IdentityService.IdentityService.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserCredential,Long> {
   Optional<UserCredential> findByUserName(String userName);
}
