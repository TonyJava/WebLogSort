package com.hongzhou.WebLogSort;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WebLogMapper extends Mapper<LongWritable, Text, KeyPair, Text>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

/*		// Split the line on space
		String[] line = value.toString().split(" ");

		if (line.length >= 4) {
			String ipAddress = line[0];
			String date = line[3].substring(1);
			String record = line[3]+ " " + line[4];

			context.write(new KeyPair(ipAddress, date), new Text(record));
		}*/
		
		// Split the line on “- - ”
		String[] line = value.toString().split("- - ");

		if (line.length == 2) {
			String ipAddress = line[0];
			String date = line[1].substring(1, 20);
			String record = line[1].substring(0,28);

			context.write(new KeyPair(ipAddress, date), new Text(record));
		}
	}
}
