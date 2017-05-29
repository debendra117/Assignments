import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<Text, Text, Text, Text>{
	
	
	String deptname="";
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		// 002_dept, hive
		// 002_emp, emp2,emp7
		
		if(key.toString().contains("dept")){
			for (Text val : values) {
				deptname=val.toString();				
			}			
		}
		if(key.toString().contains("emp")){
			for (Text val : values) {
				context.write(val, new Text(deptname));				
			}			
		}
	
	
	
	}

}
