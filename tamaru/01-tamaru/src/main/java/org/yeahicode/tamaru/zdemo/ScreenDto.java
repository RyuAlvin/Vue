package org.yeahicode.tamaru.zdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScreenDto {
    private String screenName;
    private List<SearchRslt> rsltList;
}
