package com.distributed.systems.repository;

import com.distributed.systems.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

    @Query(value="SELECT a.applicantsafm, a.description, a.location, a.application_date, a.state, a.staff_id, a.application_id FROM application a INNER JOIN users u ON (a.applicantsafm = u.afm) WHERE u.username = :email ", nativeQuery = true)
    List<Application> findByApplicantsUsername(@Param("email")String email);

    Application findAllByApplicationId(Long id);
    Application findByApplicantsAFMAndState(String afm,String state);
}
