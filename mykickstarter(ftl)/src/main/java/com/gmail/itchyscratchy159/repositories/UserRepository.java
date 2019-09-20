package com.gmail.itchyscratchy159.repositories;

import com.gmail.itchyscratchy159.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
