package com.codingshuttle.securityApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Entity(name = "sessions")
public class Sessions {

    //Sessions entity to store user sessions in the database so one session per user can be maintained and user can logout from all devices by deleting the session from the database

    @Id
    @Column(nullable = false, unique = true)
    private Long userId;

    private String token;

}
