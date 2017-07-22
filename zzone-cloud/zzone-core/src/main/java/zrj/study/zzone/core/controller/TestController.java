package zrj.study.zzone.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/22
 */
@RestController
@RequestMapping("/core/")
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("test")
    public String test() {
        return "Hello, I'm " + port;
    }

}
