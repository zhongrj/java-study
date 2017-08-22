package zrj.study.test.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/14
 */
public class ServerSocketTest1 {
    public static void main(String[] args) throws IOException {

        SocketTest1 socketTest1 = new SocketTest1();
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);

        ServerSocket server = new ServerSocket(8000);
        while (true) {
            try {
                Socket socket = server.accept();
                InputStream is = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int i = is.read(bytes);
                String string = new String(bytes, 0, i);
                System.out.printf("加载类: %s\n", string);
                Class clazz = Class.forName(string);
                System.out.println(clazz.getMethods());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
