package com.proyectowed.proyectowed.Dtos.UserDtos;

import lombok.Data;

@Data
public class UserCreatedDto {

    private Long id;
    private String fullName;
    private String email;
    private String password;
}
