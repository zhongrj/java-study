package zrj.study.zzone.ribbon.controller;

import org.springframework.web.bind.annotation.RestController;
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
        return null;
    }
}
