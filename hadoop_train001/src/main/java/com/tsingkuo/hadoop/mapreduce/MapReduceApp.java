package com.tsingkuo.hadoop.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MapReduceApp {

    /**
     * WCMapper是为了实现map task
     * map是为了读取MapReduce框架split之后的数据，也就是k1,v1，所以map方法的输入分别是k1, v1还有context（上下文对象）
     */
    public static class WCMapper extends Mapper {

        @Override
        protected void map(Object key, Object value, Context context) throws IOException, InterruptedException {
            LongWritable longWritable = new LongWritable(1);

            // 接收到的每一行数据
            String inputVaule = value.toString();

            //按照指定分隔符进行拆分
            String[] words = inputVaule.split(" ");

            context.write(new Text(words[0]), new LongWritable(Long.parseLong(words[1])));

//            for (String word : words
//                    ) {
//                //我们是通过context上下文对象来保存我们map出来的k2, v2
//                context.write(new Text(word), longWritable);
//            }
        }
    }

    /**
     * WCReducer是为了实现reduce task
     * reduce是为了合并我们map输入的数据
     */
    public static class WCReducer extends Reducer {
        @Override
        protected void reduce(Object key, Iterable values, Context context) throws IOException, InterruptedException {
            long sum = 0;

            for (Object value : values
                    ) {
                sum += Long.parseLong(value.toString());
            }

            context.write(new Text(key.toString()), new LongWritable(sum));
        }
    }

    public static class WCPartitioner extends Partitioner {
        public int getPartition(Object o, Object o2, int i) {
            String s = o.toString();
            if (s.equals("event1")) {
                return 0;
            } else if (s.equals("event2")) {
                return 1;
            } else if (s.equals("event3")) {
                return 2;
            } else if (s.equals("event4")) {
                return 3;
            }
            return 4;
        }
    }


    public static void main(String[] args) throws Exception{

        //创建Configuration
        Configuration configuration = new Configuration();

        //创建JOB
        Job job = Job.getInstance(configuration, "wordCount");

        //设置job的处理类
        job.setJarByClass(MapReduceApp.class);

        //设置作业处理的输入路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));

        //设置map相关参数
        //在写上边的WCMapper的时候没有指定key跟value的类型，我们可以指定，也可以不指定，我们可以在job设置mapper的时候来指定
        job.setMapperClass(WCMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //设置Combiner相关参数
        //Combiner的操作就是在map的task中就先进行一次reduce操作，是的Partitioner不会有那么多IO开销
        //我们在设置combiner处理类的时候，因为其逻辑上和我们reduce是一模一样的，所以我们可以用我们写好的WCReduce.class
        job.setCombinerClass(WCReducer.class);

//        //设置Partitioner相关参数
        job.setPartitionerClass(WCPartitioner.class);
        job.setNumReduceTasks(4);

        //设置reduce相关参数
        job.setReducerClass(WCReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //在设置作业处理的输出路劲前要先判断这个文件是否存在啦
        Path path = new Path(args[1]);
        FileSystem fileSystem = FileSystem.get(configuration);
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
            System.out.println("output file exists, but has deleted!");
        }

        //设置作业处理的输出路径
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
