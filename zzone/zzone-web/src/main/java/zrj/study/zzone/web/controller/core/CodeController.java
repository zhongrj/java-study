package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.service.CodeService;
import zrj.study.zzone.web.controller.BaseController;
import zrj.study.zzone.web.model.core.CodeModel;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 验证码Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
@RestController
@RequestMapping("/code/")
public class CodeController extends BaseController {

    @Autowired
    private CodeService codeService;


    /**
     * 获取验证码
     */
    @RequestMapping("get")
    public void get(@RequestBody @Valid CodeModel codeModel, HttpServletResponse response) throws Exception {

        codeService.sendCodeImage(codeModel.getMacId(), codeModel.getCode(), response.getOutputStream());

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

    }

}
