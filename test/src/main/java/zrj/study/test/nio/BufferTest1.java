package zrj.study.test.nio;

import java.nio.ByteBuffer;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/28
 */
public class BufferTest1 {

    public static void main(String[] args) {
        //产生一个ByteBuffer实例
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //对该ByteBuffer实例进行初始化
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }
        //修改buffer的position（起点）和limit（终点）
        buffer.position(3);
        buffer.limit(7);
        //对缓冲区进行分片
        ByteBuffer slice = buffer.slice();
        //对分片的数据进行操作
        for (int i = 0; i < slice.capacity(); ++i) {
            byte b = slice.get(i);
            b *= 11;
            slice.put(i, b);
        }
        //重新定位并输出结果
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }
    }

}
