package com.zhassurbek.mixproject.dao.request.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitUserRegistrationRequestDto implements Serializable {

    private String username;
    private String email;
    private String mobileNumber;

}
