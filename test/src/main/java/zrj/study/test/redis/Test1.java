package zrj.study.test.redis;

import redis.clients.jedis.Jedis;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/18
 */
public class Test1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Server is running: " + jedis.ping());

        System.out.println(jedis.get("name"));
    }
}
