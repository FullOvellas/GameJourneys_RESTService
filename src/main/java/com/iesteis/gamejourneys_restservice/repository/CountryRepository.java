package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}