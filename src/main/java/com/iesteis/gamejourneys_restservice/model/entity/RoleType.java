package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role_types")
public class RoleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_type_name")
    private String roleTypeName;

    public Long getId() {
        return id;
    }

    public String getRoleTypeName() {
        return roleTypeName;
    }
}