package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.PMBUser;

public interface PMBUserRepository extends CrudRepository<PMBUser, String> {

}
