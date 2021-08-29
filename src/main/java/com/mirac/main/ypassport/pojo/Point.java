package com.mirac.main.ypassport.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class Point implements Serializable {
    private int type;
    private int id;
    private int yId;
    private String yName;
    private int pId;
    private String pName;
    private String cName;
    private String tName;
    private String fangyi;
    private String point;
}
