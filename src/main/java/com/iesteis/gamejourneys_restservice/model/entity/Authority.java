package com.iesteis.gamejourneys_restservice.model.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

}
