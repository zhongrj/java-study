package zrj.study.util.web;

import zrj.study.util.time.Timer;

import java.util.*;

/**
 * 自制会话
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/21
 */
public class Session<K, V> extends Timer.Action {

    private long survivalTime;
    private Map<K, V> sessions;
    private Queue<Node<K>> delQueue;

    private static final long DEFAULT_INTERVAL = 1000L;
    private static final long DEFAULT_SURVIVAL_TIME = 60 * 60 * 1000L;

    public Session() {
        this(DEFAULT_INTERVAL, DEFAULT_SURVIVAL_TIME);
    }

    public Session(long interval, long survivalTime) {
        this.setInterval(interval);
        this.survivalTime = survivalTime;
        this.sessions = new HashMap<K, V>();
        this.delQueue = new LinkedList<Node<K>>();
    }

    public void put(K key, V value) {
        sessions.put(key, value);
        delQueue.add(new Node<K>(key, System.currentTimeMillis() + survivalTime));
    }

    public V get(K key) {
        return sessions.get(key);
    }

    private class Node<K> {
        private K key;
        private long expireDate;

        public Node(K key, long expireDate) {
            this.key = key;
            this.expireDate = expireDate;
        }
    }


    @Override
    public void action() {
        Node<K> node = delQueue.peek();
        if (node != null && node.expireDate <= System.currentTimeMillis()) {
            sessions.remove(delQueue.poll().key);
        }
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        final Session<String, String> session = new Session(1000L, 5000L);
        Timer timer = new Timer();
        timer.addAction(session);
        timer.start();
        session.put("1", "123");
        session.put("2", "321");
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    for (String value : session.sessions.values()) {
                        System.out.println(value);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
