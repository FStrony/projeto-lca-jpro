package com.jpro.lca.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConversaoUtil {

	public static Date converterCalendarToSQLDate(Calendar data) {
	   Date sqlDate = new Date(data.getTime().getTime());
	   return sqlDate;
	  }
	
	public static Calendar converterSQLDateToCalendar(Date data){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return  calendar;
	}
	
	public static String ExibirData(Calendar calendar, String formato){
		java.util.Date d = new java.util.Date(calendar.getTimeInMillis());
		return new SimpleDateFormat(formato).format(d);
	}
	
	public static Calendar converterStringToCalendar(String data, String formato){
		SimpleDateFormat formatoData = new SimpleDateFormat(formato);
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatoData.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
}
