package com.ms29.event.registration.repositories;

import com.ms29.event.registration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
}
