package com.codewithharshal.application_management_system.repositories;

import com.codewithharshal.application_management_system.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant,Long> {
    List<Applicant> findBystatus(String status);


    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> findApplicantByPartialName(@Param("name") String name);
}
