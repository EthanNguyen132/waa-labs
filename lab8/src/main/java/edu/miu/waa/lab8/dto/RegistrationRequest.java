package edu.miu.waa.lab8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {

    private String email;
    private String password;
    private String role;
}
