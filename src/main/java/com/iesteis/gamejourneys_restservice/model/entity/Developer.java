package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "developer_name")
    private String developerName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

}