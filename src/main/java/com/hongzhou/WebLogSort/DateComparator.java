package com.hongzhou.WebLogSort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DateComparator extends WritableComparator {
	
	public DateComparator(){
		super(KeyPair.class, true);
	}
	
	public int compare(WritableComparable k1, WritableComparable k2){
		
		KeyPair key1 = (KeyPair) k1;
		KeyPair key2 = (KeyPair) k2;
		
		int c = key1.getIpAddress().compareTo(key2.getIpAddress());
		
		try {
			String pattern = "dd/MMM/yyyy:HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			Date date1 = simpleDateFormat.parse(key1.getAccessDate().toString());
			Date date2 = simpleDateFormat.parse(key2.getAccessDate().toString());
			
			if (c == 0) {
				c = -date1.compareTo(date2);
			} else {
				return c;
			}
		} catch (ParseException e) {

		}
		
		return c;

/*		int c = key1.getIpAddress().compareTo(key2.getIpAddress());

		if (c == 0) {
			return -date1.compareTo(date2);
		} else {
			return c;
		}*/
	}
}
