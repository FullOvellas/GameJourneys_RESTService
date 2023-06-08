package com.iesteis.gamejourneys_restservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "platform_name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}