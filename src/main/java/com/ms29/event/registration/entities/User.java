package com.ms29.event.registration.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userRoleId", referencedColumnName = "id")
    private UserRole userRole;
}
