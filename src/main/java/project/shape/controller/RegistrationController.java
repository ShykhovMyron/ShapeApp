package project.shape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import project.shape.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getRegistrationPage() {
        return "registration";
    }

    @GetMapping("/home")
    public String getRegistrationPage() {
        return "registration";
    }
}
