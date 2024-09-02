package com.ust.IdentityService.IdentityService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "user-credentials")
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String userName;
    String password;
}
