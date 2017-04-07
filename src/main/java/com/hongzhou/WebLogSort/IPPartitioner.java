package com.hongzhou.WebLogSort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class IPPartitioner extends Partitioner<KeyPair, Text>{

	@Override
	public int getPartition(KeyPair key, Text value, int numReducer) {
		// TODO Auto-generated method stub
		
		return Math.abs(key.getIpAddress().hashCode() % numReducer);
	}

}
