package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Acceleration findAccelerationByName(String name);


    @Query(value="SELECT * FROM acceleration as ac" +
            " INNER JOIN candidate ca " +
            "ON ac.id = ca.acceleration_id " +
            "WHERE ca.company_id = ?1", nativeQuery = true)
    List<Acceleration> findByCompanyId(Long companyId);
}
