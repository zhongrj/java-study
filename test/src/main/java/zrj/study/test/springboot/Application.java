package zrj.study.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zrj.study.util.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/10
 */
@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @RequestMapping("download")
    public void download(HttpServletResponse response) {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+"test.tmp");

        OutputStream os = null;
        InputStream is = null;
        try {
            is = new FileInputStream("D:/data.txt ");
            os = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int i;
            while ((i = is.read(bytes)) != -1) {
                os.write(bytes, 0, i);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(os);
            IOUtils.close(is);
        }

    }
}
