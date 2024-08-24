package org.yeahicode.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/get/{id}")
    public String getUserByID(@PathVariable("id") Long id) {
        return "Hello SpringBoot" + id;
    }
}
