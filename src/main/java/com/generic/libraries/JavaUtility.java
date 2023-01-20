package com.generic.libraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public  int getRandomNo() {
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random ;

	}
	public String getSystemDate(){
	Date dt=new Date();
	String date=dt.toString();
	return date ;
}
	public String getSystemDateAndTimeInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		 Date systemdate= new Date();
		 String getDateDateAndTime=dateformat.format(systemdate);
		 System.out.println(getDateDateAndTime);
		return getDateDateAndTime.replaceAll(":","-");
	}
}
