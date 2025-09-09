package com.example.demo.Dto;

import com.example.demo.entity.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}
