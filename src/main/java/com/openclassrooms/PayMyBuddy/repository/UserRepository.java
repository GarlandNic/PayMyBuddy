package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
