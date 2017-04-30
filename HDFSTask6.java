import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSTask6 
{
	
	public static void main(String args[]) throws IOException
	{
		Configuration conf = new Configuration();
		conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/hdfs-site.xml"));
		
		FileSystem fs = FileSystem.get(conf);
		fs.copyFromLocalFile(new Path("/home/acadgild/max-temp.txt"),new Path("/user/acadgild/Pictures/"));
		System.out.println("File copied");
		
		fs.close();
	}

}
