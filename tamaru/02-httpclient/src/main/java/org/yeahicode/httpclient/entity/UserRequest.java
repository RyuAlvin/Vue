package org.yeahicode.httpclient.entity;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String username;
    private String password;
}
