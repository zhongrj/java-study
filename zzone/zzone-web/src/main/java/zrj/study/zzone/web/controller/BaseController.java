package zrj.study.zzone.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zrj.study.util.security.RSAUtils;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.web.model.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Base64;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@ConfigurationProperties(prefix = "zzone-web")
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({ZzoneException.class})
    public Result handleServiceException(ZzoneException e) {
        logger.error(e.getMessage(), e);
        return new Result(Result.FAILURE, e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        logger.warn("参数校验不通过: {}", msg);
        return new Result(Result.FAILURE, msg);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result handleBindException(Exception e) {
        logger.warn("数据格式错误: {}", e.getMessage());
        return Result.WRONG_DATA;
    }

    @ExceptionHandler({Exception.class})
    public Result handleException(Exception e) {
        logger.error("未知错误", e);
        return Result.EXCEPTION;
    }

    /**
     * 返回资源文件内容
     * 临时用用
     *
     * @param response
     * @param path     资源路径
     */
    protected void returnResource(HttpServletResponse response, String path) {
        try {
            File file = ResourceUtils.getFile(path);
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            throw new ZzoneException("返回资源异常", e);
        }
    }

    protected String decryptBase64(String m, RSAKey rsaKey) {
        if (securety) {
            return decrypt(base64decode(m), rsaKey);
        }
        return m;
    }

    protected String decrypt(byte[] bytes, RSAKey rsaKey) {
        try {
            return new String(RSAUtils.decrypt(bytes, rsaKey.getRsaPrivateKey()), "UTF-8");
        } catch (Exception e) {
            throw new ZzoneException("解密异常", e);
        }
    }

    protected byte[] base64decode(String encryptedData) {
        return Base64.getDecoder().decode(encryptedData);
    }

    protected String base64encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }


    private boolean securety;

    public boolean isSecurety() {
        return securety;
    }

    public void setSecurety(boolean securety) {
        this.securety = securety;
    }
}
