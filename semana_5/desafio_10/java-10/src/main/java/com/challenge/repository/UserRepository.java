package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {





    @Query(value = "SELECT u FROM User u JOIN u.candidates c where c.id.acceleration.name = ?1")
    List<User> findByAccelerationName(String name);

    @Query(value = "SELECT u FROM User u JOIN u.candidates c where c.id.company.id = ?1")
    List<User> findByCompanyId(Long companyId);
}
