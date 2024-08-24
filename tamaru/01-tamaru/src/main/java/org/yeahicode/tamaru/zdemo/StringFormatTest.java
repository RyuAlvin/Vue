package org.yeahicode.tamaru.zdemo;

import java.math.BigDecimal;

public class StringFormatTest {
    public static void main(String[] args) {
        String str = "预算项目名称：%s，剩余预算：%s，本次累计使用预算：%d，不足%d";
        BigDecimal b1 = new BigDecimal(0.22645454);
        BigDecimal b2 = new BigDecimal(12.00);
        BigDecimal b3 = new BigDecimal(13);
        System.out.println(String.format("%s", b1.setScale(2, BigDecimal.ROUND_DOWN).toPlainString()));
        System.out.println(String.format("%s", b1.setScale(2, BigDecimal.ROUND_DOWN).toString()));
//        System.out.println(String.format(str, "test111", b1(), b2.doubleValue(), b3.doubleValue()));
    }
}
