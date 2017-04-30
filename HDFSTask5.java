	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	import org.apache.hadoop.conf.Configuration;
	import org.apache.hadoop.fs.FSDataInputStream;
	import org.apache.hadoop.fs.FileSystem;
	import org.apache.hadoop.fs.Path;

	public class HDFSTask5 
	{
		public static void readFile(FileSystem fs) throws IOException
		{
			Path path = new Path("/user/acadgild/writeHDFS.txt");
			
			if(!fs.exists(path))
			{
				System.out.println("Input File Not Found");
				System.exit(0);
			}
			if(!fs.isFile(path))
			{
				System.out.println("Input Should be a file");
				System.exit(0);
			}
			
			FSDataInputStream in = fs.open(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			line =br.readLine();
			while(line!=null)
			{
				System.out.println(line);
				line=br.readLine();
			}
			in.close();
		}
		public static void main(String args[]) throws IOException
		{
			Configuration conf = new Configuration();
			conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/core-site.xml"));
			conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/hdfs-site.xml"));
			
			FileSystem fs = FileSystem.get(conf);
			readFile(fs);
			
			fs.close();
		}

	}
