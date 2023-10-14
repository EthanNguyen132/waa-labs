package edu.miu.waa.lab8.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
