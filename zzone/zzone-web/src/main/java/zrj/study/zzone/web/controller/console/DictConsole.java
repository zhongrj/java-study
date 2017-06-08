package zrj.study.zzone.web.controller.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.service.DictService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.Result;

/**
 * 字典管理
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
@RestController
@RequestMapping("/console/dict/")
public class DictConsole extends BaseController {

    @Autowired
    private DictService dictService;

    @RequestMapping("/add")
    public Result add() {
        return new Result(Result.SUCCESS, "选项卡添加成功");
    }

}
