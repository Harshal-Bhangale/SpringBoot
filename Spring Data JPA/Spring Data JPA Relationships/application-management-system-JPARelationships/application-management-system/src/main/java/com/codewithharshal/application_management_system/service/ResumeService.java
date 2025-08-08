package com.codewithharshal.application_management_system.service;

import com.codewithharshal.application_management_system.Entity.Applicant;
import com.codewithharshal.application_management_system.Entity.Resume;
import com.codewithharshal.application_management_system.repositories.ApplicantJpaRepository;
import com.codewithharshal.application_management_system.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    ApplicantJpaRepository applicantJpaRepository;

    @Autowired
    ResumeRepository resumeRepository;


    public Resume addResume(Long applicantId, Resume resume) {
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);

            return resumeRepository.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with id: " + applicantId);
        }
    }
}
