package org.yeahicode.tamaru.zdemo;

import java.io.UnsupportedEncodingException;

public class BigDecimalTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        BigDecimal bg1 = new BigDecimal(20);
//        BigDecimal bg2 = new BigDecimal(20);
//        System.out.println(bg1.compareTo(bg2));
//        System.out.println(Calendar.getInstance().get(1));

//        String[] strings = separateRefParts("sheet1!A1");
//        Arrays.stream(strings).forEach(System.out::println); //sheet1,A,1

//        String name = new String("import_error.xlsx".getBytes("gbk"),"ISO8859-1");
//        System.out.println(name);

        int plingPos = "shee1!A1".lastIndexOf(33);
        System.out.println(plingPos);
    }

    public static String[] separateRefParts(String reference) {
        int plingPos = reference.lastIndexOf(33); //6
        String sheetName = "sheet1";
        int start = plingPos + 1; //7
        int length = reference.length(); //8
        int loc = start; //7
        if (reference.charAt(start) == '$') {
            loc = start + 1;
        }

        while(loc < length) {
            char ch = reference.charAt(loc);
            if (Character.isDigit(ch) || ch == '$') {
                break;
            }

            ++loc;
        }

        return new String[]{sheetName, reference.substring(start, loc), reference.substring(loc)};
    }
}
