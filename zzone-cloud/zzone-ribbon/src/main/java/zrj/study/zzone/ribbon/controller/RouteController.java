package zrj.study.zzone.ribbon.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zrj.study.zzone.ribbon.service.RouteService;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/24
 */
@RestController
public class RouteController {

    private RouteService routeService;

    public String route() {
//        return routeService.route();
        RestTemplate restTemplate = new RestTemplate();
        return null;
    }
}
