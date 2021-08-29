package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Jiezhongdian {
    private int pId;
    private int yId;
    private String jiezhong;
    private Date fTime;
    private String jCompony;
    private String twice;
    private Date tTime;
    private String fangyi;
    private String point;
}
