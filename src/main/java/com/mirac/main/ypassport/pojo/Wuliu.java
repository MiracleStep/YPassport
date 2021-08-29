package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;
import java.util.Date;


@Data
@ToString
public class Wuliu {
    private String tPoint;
    private int yId;
    private String yName;
    private int yNum;
    private Date shTime;
    private Date sdTime;
    private String cName;
    private String dName;
}
