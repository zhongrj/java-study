package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.service.OptionService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.OptionModel;

/**
 * 选项卡Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/3
 */
@RestController
@RequestMapping("/option/")
public class OptionController extends BaseController {

    @Autowired
    private OptionService optionService;

    @RequestMapping("get")
    public Result get(@RequestBody OptionModel optionModel) {
        return new Result(Result.SUCCESS, "获取选项卡成功", optionService.getOptionByTypes(optionModel.getTypes()));
    }

}
