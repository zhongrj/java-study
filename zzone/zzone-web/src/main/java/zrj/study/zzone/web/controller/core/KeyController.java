package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.entity.Key;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.model.BaseModel;
import zrj.study.zzone.web.model.Result;

import javax.validation.Valid;

/**
 * 密钥Controller
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
@RestController
@RequestMapping("key")
public class KeyController {

    @Autowired
    private KeyService keyService;

    @RequestMapping("get")
    public Result get(@RequestBody @Valid BaseModel baseModel) {
        Key key = keyService.get(baseModel.getMacId());
        if (null == key) {
            key = keyService.generate(baseModel.getMacId());
        }
        return null;
    }
}
