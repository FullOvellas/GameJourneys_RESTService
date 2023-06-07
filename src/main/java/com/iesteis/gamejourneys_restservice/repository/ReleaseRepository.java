package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}