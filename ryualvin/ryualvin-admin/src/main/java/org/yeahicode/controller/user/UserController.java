package org.yeahicode.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.mapper.HrMapper;
import org.yeahicode.model.Hr;

@RestController
public class UserController {

    @Autowired
    private HrMapper hrMapper;

    @GetMapping("/user/get/{id}")
    public Hr getUserByID(@PathVariable("id") Long id) {
        Hr hr = hrMapper.selectById(id);
        return hr;
    }
}
