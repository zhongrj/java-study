package zrj.study.test.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/1
 */
public class SocketTest2 {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket(InetAddress.getLocalHost(), 8090);
        OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
        StringBuffer sb = new StringBuffer();
        sb.append("GET /page/sys/role HTTP/1.1\r\n");
        sb.append("Host: localhost:8090\r\n");
        sb.append("Connection: Keep-Alive\r\n");
        //注，这是关键的关键，忘了这里让我搞了半个小时。这里一定要一个回车换行，表示消息头完，不然服务器会等待
        sb.append("\r\n");
        osw.write(sb.toString());
        osw.flush();

    }
}
