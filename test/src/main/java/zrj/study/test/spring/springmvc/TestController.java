package zrj.study.test.spring.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("test success");
        return "test";
    }

}
