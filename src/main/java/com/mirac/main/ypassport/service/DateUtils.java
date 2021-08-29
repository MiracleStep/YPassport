package com.mirac.main.ypassport.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/*日期转换*/
public class DateUtils{

	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}
