package com.iesteis.gamejourneys_restservice.repository;

import com.iesteis.gamejourneys_restservice.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
