package zrj.study.zzone.core.service;

import org.springframework.stereotype.Service;
import zrj.study.util.validate.ValidateCodeUtils;
import zrj.study.zzone.core.common.cache.CacheManage;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.entity.Code;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码服务
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/27
 */
@Service
public class CodeService {

    // ----------------------------------------- 缓存管理 -----------------------------------------

    private static final String CACHE_CODE = "code";

    static {
        CacheManage.put(CACHE_CODE, new HashMap<String, String>()); // 需要定时清理
    }

    private static Map<String, String> getCodeMap() {
        return (Map<String, String>) CacheManage.get(CACHE_CODE);
    }




    public void sendCodeImage(String macId, Code code, OutputStream os) {
        String codeTxt = ValidateCodeUtils.createRandomCode(4);
        BufferedImage image = ValidateCodeUtils.createImage(codeTxt, code.getWidth(), code.getHeight());
        getCodeMap().put(macId, codeTxt);

        try {
            ImageIO.write(image, "JPEG", os);
        } catch (IOException e) {
            throw new ZzoneException("IO异常", e);
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                throw new ZzoneException("IO异常", e);
            }
        }
    }


    public void checkCode(String macId, String codeTxt) {
        if (null == codeTxt || !codeTxt.equalsIgnoreCase(getCodeMap().remove(macId))) {
            throw new ZzoneException("验证码错误");
        }
    }

}
