package zrj.study.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/10
 */
public class IOTest1 {
    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[1024];
        InputStream is = new FileInputStream("C:\\Users\\lenovo\\Desktop\\test.tmp");
        System.out.println(is.read(bytes));// 空是-1， 0是啥，有0吗

    }
}
