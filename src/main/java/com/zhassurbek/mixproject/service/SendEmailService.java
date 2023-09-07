package com.zhassurbek.mixproject.service;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.dao.request.common.RabbitUserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final Logger logger = LoggerFactory.getLogger(MixProjectApplication.class);

    @RabbitListener(queues = "q.send-email")
    public void sendEmail(RabbitUserRegistrationRequestDto request) {
        logger.info("Sending email to {}", request.getEmail());

    }

}
