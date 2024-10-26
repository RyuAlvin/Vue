package org.yeahicode.tamaru.zdemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest1 {
    public static void main(String[] args) {
        Map<String, Object> eaMap = new HashMap<>();


        SearchRslt rslt = new SearchRslt();
        rslt.setPrice(new BigDecimal(100));
        rslt.setItemName("Computer");
        List<SearchRslt> list = new ArrayList<>();
        list.add(rslt);

        ScreenDto screenDto = new ScreenDto();
        screenDto.setScreenName("GEA3020");
        screenDto.setRsltList(list);

        eaMap.put("GEA3020", screenDto);

        ScreenDto scr = (ScreenDto)eaMap.get("GEA3020");
        SearchRslt rslt2 = new SearchRslt();
        rslt2.setPrice(new BigDecimal(200));
        rslt2.setItemName("Airpods");
        scr.getRsltList().add(rslt2);

        System.out.println((ScreenDto)eaMap.get("GEA3020"));
    }
}
