package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Jiezhongren {
    private int pId;
    private String pName;
    private String sex;
    private int age;
    private String ph;
    private String addr;
    private int yId;
    private Date fTime;
    private String twice;
    private Date tTime;
    private String point;
}
