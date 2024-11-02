package org.yeahicode.utility.result;

import lombok.Getter;

public interface IResultCode {
    Integer getCode();
    String getMsg();
    Object getObj();
}
