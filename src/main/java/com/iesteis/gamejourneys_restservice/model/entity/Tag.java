package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tag_name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}