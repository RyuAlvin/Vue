package org.yeahicode.application.convert;

import org.springframework.stereotype.Component;
import org.yeahicode.application.dto.HrDto;
import org.yeahicode.rbac.domain.Hr;
import org.yeahicode.rbac.model.HrModel;

@Component
public class ConvertModel2Dto {

    public HrDto convert1(HrModel hrModel) {
        if (hrModel == null) {
            return new HrDto();
        }
        return HrDto.builder()
                .id(hrModel.getId())
                .name(hrModel.getName())
                .username(hrModel.getUsername())
                .password(hrModel.getPassword())
                .build();
    }

    public HrDto convert2(HrModel hrModel) {
        if (hrModel == null) {
            return new HrDto();
        }
        return HrDto.builder()
                .name(hrModel.getName())
                .phone(hrModel.getPhone())
                .telephone(hrModel.getTelephone())
                .build();
    }
}
