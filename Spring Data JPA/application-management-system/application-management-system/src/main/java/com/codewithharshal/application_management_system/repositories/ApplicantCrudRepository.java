package com.codewithharshal.application_management_system.repositories;

import com.codewithharshal.application_management_system.Entity.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantCrudRepository extends CrudRepository<Applicant, Long> {

}
