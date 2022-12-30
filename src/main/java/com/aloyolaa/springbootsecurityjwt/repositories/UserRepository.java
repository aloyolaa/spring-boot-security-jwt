package com.aloyolaa.springbootsecurityjwt.repositories;

import com.aloyolaa.springbootsecurityjwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u left join fetch u.authorities a where u.email = ?1")
    Optional<User> findByEmail(String email);

}