package org.yeahicode.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeahicode.application.convert.ConvertModel2Dto;
import org.yeahicode.application.dto.HrDto;
import org.yeahicode.rbac.model.HrModel;
import org.yeahicode.rbac.repository.HrRepository;

@Service
public class HrService {

    @Autowired
    HrRepository hrRepository;

    @Autowired
    ConvertModel2Dto convert;

    public HrDto getHrById(Long id){
        HrModel hrModel = hrRepository.getHrById(id);
        return convert.convert1(hrModel);
    }

    public HrDto getHrByPhone(String phone) {
        HrModel hrModel = hrRepository.getHrByPhone(phone);
        return convert.convert2(hrModel);
    }
}
