package com.distributed.systems.controller;

import com.distributed.systems.dto.ApplicationDto;
import com.distributed.systems.entity.Application;
import com.distributed.systems.repository.ApplicationRepository;
import com.distributed.systems.service.ApplicationService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ApplicationController {

    ApplicationService applicationService;
    ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationService applicationService,  ApplicationRepository applicationRepository){
        this.applicationService = applicationService;
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/application")
    public String application(Model model){
        ApplicationDto application = new ApplicationDto();
        model.addAttribute("application",application);
        return "/application";
    }

    @PostMapping("/application/save")
    public String applicationSave(@ModelAttribute("application") ApplicationDto applicationDto,BindingResult result,Model model){
        Application existingApplication = applicationService.findApplicationByApplicantsAFMAndState(applicationDto.getApplicantsAFM(),applicationDto.getState());
        if(existingApplication!=null){
            result.rejectValue(null,null,"There is already an application submitted");
        }

        if(result.hasErrors()){
            model.addAttribute("application",applicationDto);
            return "/application";
        }

        applicationService.saveApplication(applicationDto);
        return "redirect:/application?success";
    }

    @GetMapping("/applications")
    public String applications(@CurrentSecurityContext(expression="authentication?.name")String email, Model model){
        List<Application> applications = applicationRepository.findByApplicantsUsername(email);
        model.addAttribute("applications",applications);
        return "applications";
    }
//

}
