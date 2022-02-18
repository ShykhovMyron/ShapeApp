package project.shape.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.shape.model.request.CreateUserRequest;
import project.shape.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/registration")
    public String getRegistrationPage(CreateUserRequest createUserRequest,
                                      @ModelAttribute("errors") ArrayList<String> errors) {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String createUser(@Valid CreateUserRequest createUserRequest,
                             BindingResult validResult,
                             @ModelAttribute("errors") ArrayList<String> errors,
                             RedirectAttributes redirectAttributes) {
        try {
            if (validResult.hasErrors()) {
                errors.add(validResult.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .findFirst()
                        .orElse("Error"));
            } else {
                userService.createUser(createUserRequest.getUsername(), createUserRequest.getPassword());
                return "redirect:login";
            }
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        redirectAttributes.addFlashAttribute("errors", errors);
        return "redirect:registration";
    }
}
