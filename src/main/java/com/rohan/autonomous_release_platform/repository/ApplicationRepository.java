package com.rohan.autonomous_release_platform.repository;

import com.rohan.autonomous_release_platform.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}