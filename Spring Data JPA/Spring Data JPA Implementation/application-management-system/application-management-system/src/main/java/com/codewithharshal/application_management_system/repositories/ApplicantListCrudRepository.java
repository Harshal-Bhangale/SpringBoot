package com.codewithharshal.application_management_system.repositories;

import com.codewithharshal.application_management_system.Entity.Applicant;
import org.springframework.data.repository.ListCrudRepository;

public interface ApplicantListCrudRepository extends ListCrudRepository<Applicant,Long> {
}
