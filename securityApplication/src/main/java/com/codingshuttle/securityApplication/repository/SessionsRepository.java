package com.codingshuttle.securityApplication.repository;

import com.codingshuttle.securityApplication.entities.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Long> {
    boolean existsByUserId(Long userId);

    Sessions findByUserId(Long userId);

}