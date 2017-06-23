package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.BaseModel;
import zrj.study.zzone.web.model.Result;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 密钥Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
@RestController
@RequestMapping("/core/key/")
public class KeyController extends BaseController {

    @Autowired
    private KeyService keyService;

    /**
     * 获取密钥
     */
    @RequestMapping("get")
    public Result get(@RequestBody @Valid BaseModel baseModel) {
        RSAKey rsaKey = keyService.newKey(baseModel.getSource());
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("keyId", rsaKey.getId());
        resultMap.put("pubKey", base64encode(rsaKey.getRsaPublicKey().getEncoded()));
        return new Result(Result.SUCCESS, "获取密钥成功", resultMap);
    }

}
