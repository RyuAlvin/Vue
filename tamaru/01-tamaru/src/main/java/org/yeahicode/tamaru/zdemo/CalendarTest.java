package org.yeahicode.tamaru.zdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
//        Calendar instance = Calendar.getInstance();
//        instance.set(2022, 1,2);
//        instance.setFirstDayOfWeek(Calendar.MONDAY);
//        System.out.println(instance.get(Calendar.WEEK_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2022-02-05");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            System.out.println(c.get(Calendar.DAY_OF_WEEK));
            c.setFirstDayOfWeek(Calendar.MONDAY);
            System.out.println(c.get(Calendar.DAY_OF_WEEK));
//            System.out.println(c.get(Calendar.WEEK_OF_MONTH));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.YEAR, -1);
//        System.out.println(calendar.getTime());
    }
}
