package com.signup.service.signupService.repository;

import com.signup.service.signupService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    //additional query for user login
    @Modifying
    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> loginUser(@Param("email") String email);

}