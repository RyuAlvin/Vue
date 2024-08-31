package org.yeahicode.rbac.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hr")
public class Hr implements Serializable {

    @TableId
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
