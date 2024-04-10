package com.distributed.systems.service.impl;

import com.distributed.systems.dto.ApplicationDto;
import com.distributed.systems.entity.Application;
import com.distributed.systems.repository.ApplicationRepository;
import com.distributed.systems.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    public ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void saveApplication(ApplicationDto applicationDto) {
        Application application = new Application();
        application.setApplicationId(applicationDto.getApplicationId());
        application.setApplicantsAFM(applicationDto.getApplicantsAFM());
        application.setApplicationDate(new Date(System.currentTimeMillis()));
        application.setState("Pending");
        application.setLocation(applicationDto.getLocation());
        application.setDescription(applicationDto.getDescription());
        application.setStaffId(applicationDto.getStaffId());

        applicationRepository.save(application);
    }

    @Override
    public Application findApplicationByApplicantsAFMAndState(String applicantsAFM, String state) {
        return applicationRepository.findByApplicantsAFMAndState(applicantsAFM,state);
    }

//    @Override
//    public Application findApplicationById(Long id) {
//        return applicationRepository.findAllByApplicationId(id);
//    }


}
