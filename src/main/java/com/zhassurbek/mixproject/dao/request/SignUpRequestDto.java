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

    private String name;
    private String surname;
    private String email;
    private String password;

    private String username;

}
