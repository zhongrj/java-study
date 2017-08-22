package zrj.study.test.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/1
 */
public class SocketTest1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("baidu.com", 80);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        OutputStream os = socket.getOutputStream();
        String http = "GET / HTTP/1.1\n" +
                "Host: www.baidu.com\n" +
                "Connection: keep-alive\n" +
                "Pragma: no-cache\n" +
                "Cache-Control: no-cache\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, sdch, br\n" +
                "Accept-Language: zh-CN,zh;q=0.8\n" +
                "Cookie: BAIDUID=0ADD94ADA227E9E7B1FB7360B73879D5:FG=1; BIDUPSID=0ADD94ADA227E9E7B1FB7360B73879D5; PSTM=1484017253; BDUSS=hocHVjSjVTMkg4bH5xWllsT0lTRlYwTjljN2RuMjcwbzdXeUdjSFhPU01oSEJaSVFBQUFBJCQAAAAAAAAAAAEAAACg6UgMenJqMTk5MzEyMTEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIz3SFmM90hZZl; MCITY=-340%3A; H_PS_645EC=c5c0jvJJUcWmdjyx3tBuQZfbiY2iHzaX0B0t7B0KM7rafsOT2sw0hhWZgq9ZwIFceBZn; BD_CK_SAM=1; PSINO=7; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BD_HOME=1; H_PS_PSSID=1457_21114_18559_23489_20718; BD_UPN=12314353\n\n";
        os.write(http.getBytes());
        os.flush();

        String readline;
        while ((readline = in.readLine()) != null) {
            System.out.println(readline);
        }

        System.out.println("end");

    }


    public void test() {
        System.out.println(123);
    }
}
