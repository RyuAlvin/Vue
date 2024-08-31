package org.yeahicode.rbac.convert;

import org.springframework.stereotype.Component;
import org.yeahicode.rbac.domain.Hr;
import org.yeahicode.rbac.model.HrModel;

@Component
public class ConvertDo2Model {

    public HrModel convert1(Hr hr) {
        if (hr == null) {
            return new HrModel();
        }
        return HrModel.builder()
                .id(hr.getId())
                .name(hr.getName())
                .username(hr.getUsername())
                .password(hr.getPassword())
                .build();
    }

    public HrModel convert2(Hr hr) {
        if (hr == null) {
            return new HrModel();
        }
        return HrModel.builder()
                .name(hr.getName())
                .phone(hr.getPhone())
                .telephone(hr.getTelephone())
                .build();
    }
}
