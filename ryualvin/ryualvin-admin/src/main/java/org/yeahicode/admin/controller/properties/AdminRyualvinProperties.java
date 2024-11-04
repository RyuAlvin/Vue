package org.yeahicode.admin.controller.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "admin.ryualvin")
public class AdminRyualvinProperties {
    private String address;
    private String name;
    private Integer age;
    private boolean married;
}
