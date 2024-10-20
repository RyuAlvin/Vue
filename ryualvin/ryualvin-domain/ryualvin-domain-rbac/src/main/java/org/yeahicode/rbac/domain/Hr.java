package org.yeahicode.rbac.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yeahicode.common.domain.BaseEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hr")
public class Hr extends BaseEntity<Long> {

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
