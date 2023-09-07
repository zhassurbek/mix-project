package com.zhassurbek.mixproject.controller;

import com.zhassurbek.mixproject.dao.request.common.RabbitUserRegistrationRequestDto;
import com.zhassurbek.mixproject.dao.response.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value ="/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class RabbitUserController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/user")
    public ApiResponse createUser(@RequestBody RabbitUserRegistrationRequestDto request) {

        rabbitTemplate.convertAndSend("", "user-registration", request);
        return new ApiResponse("Ok");

    }

}
