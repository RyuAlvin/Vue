package org.yeahicode.tamaru.zdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRslt {

    private BigDecimal price;
    private String itemName;
}
