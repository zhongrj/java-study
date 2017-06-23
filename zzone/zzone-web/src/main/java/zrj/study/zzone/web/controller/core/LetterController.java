package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.entity.Letter;
import zrj.study.zzone.core.service.LetterService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.Result;

/**
 * 站内信Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
@RestController
@RequestMapping("/core/letter/")
public class LetterController extends BaseController {

    @Autowired
    private LetterService letterService;

    @RequestMapping("get")
    public Result get() {
        return null;
    }

}
