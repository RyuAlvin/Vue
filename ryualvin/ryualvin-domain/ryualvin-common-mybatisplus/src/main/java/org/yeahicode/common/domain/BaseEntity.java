package org.yeahicode.common.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity<T> implements Serializable {
    private T id;
}
