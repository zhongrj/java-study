package zrj.study.test.jvm;

import java.nio.ByteBuffer;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/7
 */
public class DirectBufferOOM1 {
    public static void main(String[] args) {
        while (true) {
            ByteBuffer.allocateDirect(100 * 1024);
        }
    }
}
