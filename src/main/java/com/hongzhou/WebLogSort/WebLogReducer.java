package com.hongzhou.WebLogSort;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WebLogReducer extends Reducer<KeyPair, Text, Text, Text>{
	
	public void reduce(KeyPair key, Iterable<Text> values, Context context) 
			throws IOException, InterruptedException {
		
		Iterator<Text> it = values.iterator();
		if (it.hasNext()){
			context.write(key.getIpAddress(), values.iterator().next());
		}
		
	}
}
