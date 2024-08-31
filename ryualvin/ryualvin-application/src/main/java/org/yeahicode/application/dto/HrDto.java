package org.yeahicode.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HrDto implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private String telephone;
    private String address;
    private String enabled;
    private String username;
    private String password;
    private String userface;
    private String remark;
}
