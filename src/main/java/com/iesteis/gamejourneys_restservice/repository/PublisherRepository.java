package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}