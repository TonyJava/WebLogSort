package com.hongzhou.WebLogSort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class IPAddressDateComparator extends WritableComparator{
	
	public IPAddressDateComparator(){
		super(KeyPair.class, true);
	}
	
	public int compare(WritableComparable k1, WritableComparable k2){
		KeyPair key1 = (KeyPair) k1;
		KeyPair key2 = (KeyPair) k2;
		
		return key1.getIpAddress().compareTo(key2.getIpAddress());
	}
}
