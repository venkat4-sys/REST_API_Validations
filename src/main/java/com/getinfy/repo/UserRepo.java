package com.getinfy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getinfy.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
