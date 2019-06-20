package com.example.watchshop.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    /**
     * Provide convenient methods for UserService to query Database
     */
    User findByBenutzerNameAndPasswort(String benuzerName, String password);

    User findByBenutzerName(String benutzerName);
}
