package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Remake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemakeRepository extends JpaRepository<Remake, Long> {
}