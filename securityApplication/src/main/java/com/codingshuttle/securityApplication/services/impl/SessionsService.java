package com.codingshuttle.securityApplication.services.impl;

import com.codingshuttle.securityApplication.entities.Sessions;
import com.codingshuttle.securityApplication.repository.SessionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SessionsService {

    private final SessionsRepository sessionsRepository;

    public SessionsService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }

    public Sessions saveSession(Long userId, String token) {

        if (sessionsRepository.existsByUserId(userId)) {
            // Handle the case where a session already exists for the user
            // For example, you might want to delete the existing session or update it
            log.info("Session already exists for userId {}. Deleting existing session.", userId);
            sessionsRepository.deleteById(userId);
        }

        Sessions session = new Sessions();
        session.setUserId(userId);
        session.setToken(token);
        log.info("Saving new session for userId {} with token {}", userId, token);
        return sessionsRepository.save(session);
    }

    public boolean isSessionValid(Long userId, String token) {
        Sessions sessions = sessionsRepository.findByUserId(userId);
        if (sessions != null && sessions.getToken().equals(token)) {
            log.info("Session is valid for userId {} with token {}", userId, token);
            return true;
        }
        log.info("Session is invalid for userId {} with token {}", userId, token);
        return false;
    }

}
