package org.yeahicode.tamaru.reflection;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class AnnoMappingTest07 {
    public static void main(String[] args) throws NoSuchFieldException {
        Class c1 = Member.class;
        RyuTable rt = (RyuTable) c1.getAnnotation(RyuTable.class);
        Field id = c1.getDeclaredField("id");
        System.out.println("表名：" + rt.value());
        RyuField rf = id.getAnnotation(RyuField.class);
        String colName = rf.name();
        String colType = rf.type();
        int colLen = rf.length();
        System.out.println(String.format("%s %s (%s)", colName, colType, colLen));
    }
}

@RyuTable("t_member")
@Data
class Member {
    @RyuField(name = "member_id", type = "varchar", length = 10)
    private String id;
    @RyuField(name = "member_name", type = "varchar", length = 50)
    private String name;
    @RyuField(name = "member_age", type = "int", length = 3)
    private Integer age;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RyuTable {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface RyuField {
    String name();

    String type();

    int length();
}