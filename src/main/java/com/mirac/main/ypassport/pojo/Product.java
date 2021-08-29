package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@Data
@ToString
public class Product {
    private int yId;
    private String yType;
    private String yName;
    private int num;
    private Date pTime;
    private String cName;
}
