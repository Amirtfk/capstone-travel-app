package de.neuefische.backend.model;


import lombok.Data;

@Data
public class CreateUserDto {

    private String username;
    private String password;
    private String email;
}
