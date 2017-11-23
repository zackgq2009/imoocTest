package com.tsingkuo.jedisTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by johnnykuo on 2017/11/10.
 */
public class JedisTest1 {
    @Test
    /**
     * 单例连接，并添加、查询数据
     */
    public void jedisTest() {
        JedisShardInfo shardInfo = new JedisShardInfo("127.0.0.1", "6379");
        shardInfo.setPassword("ShLjyF7VI5wrzNIYjx52zR09CiGWMaGx");
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = new Jedis(shardInfo);
        jedis.set("name", "a;lsdkja;lsdkfj");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    @Test
    /**
     * 还可以通过连接池的方式进行连接
     */
    public void jedisPoolTest() {
        //创建一个连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(10);

        //通过配置文件跟host\port来创建一个连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.1.9", 6379);

        //通过.getResource()方法来创建一个Jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("age", "12121");
        System.out.println(jedis.get("age"));

        jedis.close();
        jedisPool.close();
    }

    @Test
    /**
     * 通过单例连接，来测试hash类型的存储、取值、删除等等操作
     */
    public void jedisHashTest() {
        Jedis jedis = new Jedis("192.168.1.9", 6379);
        jedis.hset("teacher", "name", "tim");
        Map<String, String> map = new HashMap<String, String>();
        map.put("age", "18");
        map.put("sex", "male");
        jedis.hmset("teacher", map);
        System.out.println(jedis.hget("teacher", "name"));
        System.out.println(jedis.hmget("teacher", "name", "age", "sex"));
        System.out.println(jedis.hgetAll("teacher"));
        System.out.println(jedis.hincrBy("teacher", "age", 55));
        System.out.println(jedis.hlen("teacher"));
        System.out.println("老师的名字：" + jedis.hexists("teacher", "name") + "   学生的名字：" + jedis.hexists("students", "name") + "  老师的密码：" + jedis.hexists("teacher", "age"));
        Set<String> set = jedis.hkeys("teacher");
        for (String key : set
                ) {
            System.out.println(key);
        }
        List<String> values = jedis.hvals("teacher");
        for (String value : values
                ) {
            System.out.println(value);
        }
        jedis.hdel("teacher", "sex");
        System.out.println(jedis.hlen("teacher"));
        jedis.del("teacher");
        System.out.println(jedis.hlen("teacher"));
    }

    @Test
    /**
     * 通过单例连接，来测试list类型的存储、取值、删除等操作
     */
    public void jedisListTest() {
        Jedis jedis = new Jedis("192.168.1.9", 6379);
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "1", "2", "3");
        System.out.println(jedis.lrange("mylist", 0, -1));
        System.out.println(jedis.lpushx("mylist1", "asdf"));
        System.out.println(jedis.rpushx("mylist1", "asdf"));
        System.out.println(jedis.lrange("mylist1", 0, -1));
        System.out.println(jedis.llen("mylist"));
        jedis.lset("mylist", 2, "mmmmmmmmmmm");
        jedis.linsert("mylist", BinaryClient.LIST_POSITION.BEFORE, "b", "123");
        jedis.linsert("mylist", BinaryClient.LIST_POSITION.AFTER, "b", "456");
        System.out.println(jedis.lrange("mylist", 0, -1));
        jedis.lrem("mylist", 5, "3");
        System.out.println(jedis.lrange("mylist", 0, -1));
        System.out.println(jedis.lpop("mylist"));
        System.out.println(jedis.rpop("mylist"));
        System.out.println(jedis.lrange("mylist", 0, -1));
        System.out.println(jedis.rpoplpush("mylist", "mylist1"));
        System.out.println(jedis.lrange("mylist1", 0, -1));
    }

    @Test
    /**
     * 通过单例连接，来测试set类型的存储、取值、删除等操作
     */
    public void jedisSetTest() {
        Jedis jedis = new Jedis("192.168.1.9", 6379);
        System.out.println(jedis.sadd("myset", "1", "2", "3"));
        System.out.println(jedis.sadd("myset", "1", "2", "3"));
        System.out.println(jedis.sadd("myset", "a", "b", "c"));
        System.out.println(jedis.smembers("myset"));
        System.out.println(jedis.sismember("myset", "asdf"));
        System.out.println(jedis.sismember("myset", "a"));
        System.out.println(jedis.sadd("myset1", "1", "2", "c"));
        System.out.println(jedis.sadd("myset2", "1", "b", "2", "3"));
        System.out.println(jedis.sdiff("myset1", "myset2"));
        System.out.println(jedis.sdiff("myset2", "myset1"));
        System.out.println(jedis.scard("myset"));
        System.out.println(jedis.sinter("myset1", "myset2"));
        System.out.println(jedis.sunion("myset1", "myset2"));
        System.out.println(jedis.sdiffstore("newset", "myset1", "myset2"));
        System.out.println(jedis.smembers("newset"));
        System.out.println(jedis.sinterstore("newset", "myset1", "myset2"));
        System.out.println(jedis.smembers("newset"));
        System.out.println(jedis.sunionstore("newset", "myset1", "myset2"));
        System.out.println(jedis.smembers("newset"));
        System.out.println(jedis.srandmember("myset"));
    }

    @Test
    /**
     * 通过单例连接，来测试sorted-set类型的存储，取值，删除等操作
     */
    public void jedisSortedSetTest() {
        Jedis jedis = new Jedis("192.168.1.9", 6379);
//        jedis.select(1)
        System.out.println(jedis.zadd("mysort", 60, "guoqing"));
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("shen", Double.valueOf(90));
        map.put("zhu", Double.valueOf(5));
        System.out.println(jedis.zadd("mysort", map));
        System.out.println(jedis.zscore("mysort", "guoqing"));
        System.out.println(jedis.zcard("mysort"));
        System.out.println(jedis.zrangeWithScores("mysort", 0, -1));
        System.out.println(jedis.zrange("mysort", 0, -1));
        System.out.println(jedis.zrevrange("mysort", 0, -1));
        System.out.println(jedis.zincrby("mysort", 35, "zhu"));
        System.out.println(jedis.zcount("mysort", 60, 90));
        System.out.println(jedis.zremrangeByScore("mysort", 0, 60));
        System.out.println(jedis.zcard("mysort"));
        System.out.println(jedis.zremrangeByRank("mysort", 0, jedis.zcard("mysort")));
        System.out.println(jedis.zcard("mysort"));
        System.out.println(jedis.randomKey());
    }
}


















