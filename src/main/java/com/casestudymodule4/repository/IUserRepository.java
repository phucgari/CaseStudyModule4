package com.casestudymodule4.repository;

import com.casestudymodule4.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String user);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
