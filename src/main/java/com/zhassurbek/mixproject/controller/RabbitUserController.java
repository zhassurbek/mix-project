package com.zhassurbek.mixproject.controller;

import com.zhassurbek.mixproject.MixProjectApplication;
import com.zhassurbek.mixproject.dao.request.common.RabbitUserRegistrationRequestDto;
import com.zhassurbek.mixproject.dao.response.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value ="/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class RabbitUserController {

    private final RabbitTemplate rabbitTemplate;
    private final Logger log = LoggerFactory.getLogger(MixProjectApplication.class);

    @PostMapping("/createUser")
    public ApiResponse createUser(@RequestBody RabbitUserRegistrationRequestDto request) {
        log.info("Received request to create user: {}", request);
        rabbitTemplate.convertAndSend("", "q.user-registration", request);
        return new ApiResponse("Ok");
    }

}
