package org.yeahicode.springcloud;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneTest {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
    }
}
