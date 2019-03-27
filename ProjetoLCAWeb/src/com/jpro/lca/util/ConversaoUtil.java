package com.jpro.lca.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConversaoUtil {

	public static Date converterCalendarToSQLDate(Calendar data) {
		if (data != null){ 
			Date sqlDate = new Date(data.getTime().getTime());
			return sqlDate;
	  }else {
			return null;
		}
	}
	
	public static Calendar converterSQLDateToCalendar(Date data){
		if (data != null){ 
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			return  calendar;
		} else {
			return null;
		}
	}
	
	public static String ExibirData(Calendar calendar, String formato){
		if (calendar != null){ 
			java.util.Date d = new java.util.Date(calendar.getTimeInMillis());
			return new SimpleDateFormat(formato).format(d);
		} else {
				return null;
		}
	}
	
	public static Calendar converterStringToCalendar(String data, String formato){
		if (data != null){ 
			SimpleDateFormat formatoData = new SimpleDateFormat(formato);
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(formatoData.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return c;
		} else {
			return null;
		}
	}
	
	
}
