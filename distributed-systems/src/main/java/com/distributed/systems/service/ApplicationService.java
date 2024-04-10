package com.distributed.systems.service;

import com.distributed.systems.dto.ApplicationDto;
import com.distributed.systems.entity.Application;

import java.util.List;

public interface ApplicationService {
    void saveApplication(ApplicationDto applicationDto);

//    Application findApplicationById(Long applicationId);

    Application findApplicationByApplicantsAFMAndState(String applicantsAFM, String state);
}
