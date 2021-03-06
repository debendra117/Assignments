import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
     //1,name,2000,001
		String deptid=value.toString().split(",")[3]+"_emp";
		// 001_emp, value'
	
		context.write(new Text(deptid), value);
	
	
	}
	
	
}
