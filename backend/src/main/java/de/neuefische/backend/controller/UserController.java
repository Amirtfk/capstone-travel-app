package de.neuefische.backend.controller;

import de.neuefische.backend.model.CreateUserDto;
import de.neuefische.backend.service.AppUsersDetailService;
import de.neuefische.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final AppUsersDetailService appUsersDetailService;

    @Autowired
    public UserController(UserService userService, AppUsersDetailService appUsersDetailService) {
        this.userService = userService;
        this.appUsersDetailService = appUsersDetailService;
    }


    @GetMapping("/login")
    public String login(){
    return appUsersDetailService.loadUserByUsername(
            SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName())
            .getUsername();
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/register")
    public String register(@RequestBody CreateUserDto createUserDto) {
        return userService.register(createUserDto);
    }

}
