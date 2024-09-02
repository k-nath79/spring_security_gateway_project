package com.ust.IdentityService.IdentityService.repository;

import com.ust.IdentityService.IdentityService.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserCredential,Long> {
    UserCredential findByUserName(String userName);
}
