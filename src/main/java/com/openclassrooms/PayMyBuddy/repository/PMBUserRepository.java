package com.openclassrooms.PayMyBuddy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.PMBUser;

public interface PMBUserRepository extends CrudRepository<PMBUser, String> {

	Optional<PMBUser> findByEmail(String email);

}
