import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JoinDriver {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException, URISyntaxException {
		Configuration conf=new Configuration();
		
		conf.set("mapreduce.output.textoutputformat.separator", ",");
		//conf.set("mapreduce.output.fileoutputformat.compress", "true");
		
		Job job=Job.getInstance(conf, "Map Side Joins");
		
job.addCacheFile(new URI("/home/hadoop/YARNBOX/WORKSPACES/Sept2016WEBatch_GitRepo/SET2/MapReduceCode/Joins-MapReduce/input/dept"));
		
		job.setJarByClass(JoinDriver.class);
		job.setMapperClass(EmpMapper.class);
		//job.setReducerClass(JoinReducer.class);
		job.setNumReduceTasks(0);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}
	
}
