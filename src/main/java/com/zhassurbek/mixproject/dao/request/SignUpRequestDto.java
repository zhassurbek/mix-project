package com.zhassurbek.mixproject.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String username;

}
