package com.codewithharshal.application_management_system.service;

import com.codewithharshal.application_management_system.Entity.Applicant;
import com.codewithharshal.application_management_system.repositories.ApplicantCrudRepository;
import com.codewithharshal.application_management_system.repositories.ApplicantJpaRepository;
import com.codewithharshal.application_management_system.repositories.ApplicantListCrudRepository;
import com.codewithharshal.application_management_system.repositories.ApplicationPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;


    @Autowired
    private ApplicationPagingAndSortingRepository applicationPagingAndSortingRepository;

    @Autowired
    private ApplicantListCrudRepository applicantListCrudRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;


    public List<Applicant> getAllApplicants()
    {
        /*
        In Older Version the CurdRepository Returns rhe Iterable not directly list.
        So the Iterable need to convert into the List
        and then Return;
            Iterable<Applicant> all = applicantCrudRepository.findAll();
            List<Applicant> applicantList = new ArrayList<>();
            all.forEach(applicantList::add);
            return applicantList;
         */

//        List<Applicant> all = applicantListCrudRepository.findAll();
//        return  all;
        // or
        return applicantListCrudRepository.findAll();
    }

    public List<Applicant> getApplicantByStatus(String status)
    {
        return applicantJpaRepository.findBystatus(status);
    }

    public List<Applicant> getApplicantByPartialName(String name)
    {
        return applicantJpaRepository.findApplicantByPartialName(name);
    }


    public Applicant saveApplicantCrud(Applicant applicant)
    {
        return applicantCrudRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size)
    {
        return applicationPagingAndSortingRepository.findAll(PageRequest.of(page,size));
    }
}
