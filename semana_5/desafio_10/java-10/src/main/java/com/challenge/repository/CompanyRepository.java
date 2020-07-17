package com.challenge.repository;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {




    @Query(value = "SELECT DISTINCT c FROM Company c JOIN c.candidates ca where ca.id.acceleration.id = ?1")
    List<Company> findByAccelerationId(Long accelerationId);


    @Query(value = "select  u.* from users u join candidate c on u.id = c.user_id join company cp on c.company_id = cp.id where cp.id = :companyId", nativeQuery = true)
    List<User> findByUserId(@Param("companyId") Long companyId);



}
