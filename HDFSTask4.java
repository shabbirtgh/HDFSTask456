
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

public class HDFSTask4 
{
	
	public static void main(String args[]) throws IOException
	{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/hdfs-site.xml"));
		
		FileSystem fs = FileSystem.get(conf);
		FileStatus[] status = fs.listStatus(new Path("/user/acadgild/"));
		for(FileStatus st : status)
		{
			long k= st.getModificationTime();
			if(st.getModificationTime()>0)
			{
			System.out.println(" Path " +st.getPath().toString());
			}
			if(fs.isDirectory(st.getPath()))
			{
			FileStatus[] status2 = fs.listStatus(new Path(st.getPath().toString()));
			for(FileStatus st2:status2)
			{
				if(st2.getModificationTime()>0)
				{
				System.out.println(" Path " +st2.getPath().toString());
				}
				
			}
			}
	    }
		
		fs.close();
	}

}
