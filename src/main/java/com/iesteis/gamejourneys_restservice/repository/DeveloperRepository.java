package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}