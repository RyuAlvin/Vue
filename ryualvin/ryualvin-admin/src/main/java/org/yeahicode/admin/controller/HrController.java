package org.yeahicode.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.application.dto.HrDto;
import org.yeahicode.application.service.HrService;

@RestController
public class HrController {

    @Autowired
    HrService hrService;

    @GetMapping("/hr/id/{id}")
    public HrDto getHrById(@PathVariable("id") Long id) {
        HrDto hrDto = hrService.getHrById(id);
        return hrDto;
    }

    @GetMapping("/hr/phone/{phone}")
    public HrDto getHrByPhone(@PathVariable("phone") String phone) {
        HrDto hrDto = hrService.getHrByPhone(phone);
        return hrDto;
    }
}
