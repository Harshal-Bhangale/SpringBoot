package com.codewithharshal.application_management_system.repositories;

import com.codewithharshal.application_management_system.Entity.Applicant;
import com.codewithharshal.application_management_system.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Long> {

}
