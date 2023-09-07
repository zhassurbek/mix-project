package com.zhassurbek.mixproject.service;

import com.zhassurbek.mixproject.dao.request.common.RabbitUserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRegistrationListenerService {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {"q.user-registration"})
    public void onUserRegistration(RabbitUserRegistrationRequestDto event) {
        log.info("User Registration Event Recieved: {} ", event);

        executeRegistration(event);


        rabbitTemplate.convertAndSend("x.post-registration", "", event);
    }

    private void executeRegistration(RabbitUserRegistrationRequestDto event) {
        log.info("Executing User Registration Event: {}", event);

        throw new RuntimeException("Registration Failed");

    }
}