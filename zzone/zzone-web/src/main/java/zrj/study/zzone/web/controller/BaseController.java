package zrj.study.zzone.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import zrj.study.util.security.RSAUtils;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.web.controller.aop.exception.ExceptionAdvice;

import java.util.Base64;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
@ConfigurationProperties(prefix = "zzone-web")
public abstract class BaseController extends ExceptionAdvice {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * (base64 + rsa) 密文解密
     *
     * @param m      密文
     * @param rsaKey rsa密钥
     * @return 明文
     */
    protected String decryptBase64(String m, RSAKey rsaKey) {
        if (securety) {
            return decrypt(base64decode(m), rsaKey);
        }
        return m;
    }

    /**
     * rsa解密
     *
     * @param bytes  密文
     * @param rsaKey rsa密钥
     * @return 明文
     */
    protected String decrypt(byte[] bytes, RSAKey rsaKey) {
        try {
            return new String(RSAUtils.decrypt(bytes, rsaKey.getRsaPrivateKey()), "UTF-8");
        } catch (Exception e) {
            throw new ZzoneException("解密异常", e);
        }
    }

    /**
     * base64解密
     *
     * @param encryptedData 密文
     * @return 明文
     */
    protected byte[] base64decode(String encryptedData) {
        return Base64.getDecoder().decode(encryptedData);
    }

    /**
     * base64加密
     *
     * @param bytes 明文
     * @return 密文
     */
    protected String base64encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }


    /**
     * 用于取消加解密服务
     */
    private boolean securety;

    public boolean isSecurety() {
        return securety;
    }

    public void setSecurety(boolean securety) {
        this.securety = securety;
    }

}
