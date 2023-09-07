package com.zhassurbek.mixproject.service;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.dao.request.common.RabbitUserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendSmsService {

    private final Logger logger = LoggerFactory.getLogger(MixProjectApplication.class);

    @RabbitListener(queues = "q.send-sms")
    public void sendSms(RabbitUserRegistrationRequestDto request) {
        logger.info("Sending sms to {} ", request.getMobileNumber());
    }
}
