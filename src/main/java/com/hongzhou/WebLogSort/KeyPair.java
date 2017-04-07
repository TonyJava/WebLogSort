package com.hongzhou.WebLogSort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class KeyPair implements WritableComparable<KeyPair> {

	// the key pair holds the IP addresses and Date to access
	private Text ipAddress;
	private Text accessDate;
	
	public KeyPair(){
		ipAddress = new Text();
		accessDate = new Text();
	}
	
	public KeyPair(String ip, String date){
		ipAddress = new Text(ip);
		accessDate = new Text(date);
	}
	
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		ipAddress.readFields(in);
		accessDate.readFields(in);
	}
	
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		ipAddress.write(out);
		accessDate.write(out);
	}

	public int compareTo(KeyPair otherPair) {
		// TODO Auto-generated method stub
		int c = ipAddress.compareTo(otherPair.ipAddress);
		if (c != 0){
			return c;
		} else {
			return accessDate.compareTo(otherPair.accessDate);
		}
	}

	public Text getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(Text ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Text getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Text accessDate) {
		this.accessDate = accessDate;
	}
}
