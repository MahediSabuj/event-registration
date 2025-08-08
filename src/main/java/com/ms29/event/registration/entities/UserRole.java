package com.ms29.event.registration.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_roles")
@Getter @Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userRoleName;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> user;
}
