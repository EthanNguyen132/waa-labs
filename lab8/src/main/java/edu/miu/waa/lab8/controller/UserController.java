package edu.miu.waa.lab8.controller;


import edu.miu.waa.lab8.dto.RegistrationRequest;
import edu.miu.waa.lab8.model.User;
import edu.miu.waa.lab8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody RegistrationRequest reg) {
        return userService.save(reg);
    }
}
