package com.scm.contact.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scm.contact.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
  // extra methods for db related query
  // custom query method
  // custom finder method
  Optional<User> findByEmail(String email);

  Optional<User> findByEmailAndPassword(String email, String password);
  

  
    Optional<User> findByEmailToken(String id);
}
