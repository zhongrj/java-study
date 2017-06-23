package zrj.study.zzone.web.controller.core;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zrj.study.util.security.RSAUtils;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.controller.BaseControllerTest;

import java.security.Key;
import java.util.Base64;
import java.util.Map;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
public class KeyControllerTest extends BaseControllerTest{

    @Autowired
    private KeyService keyService;

    @Test
    public void key() throws Exception {
        String pubKeyString = getPubKey();

        String srcText = "钟如劼";
        byte[] pubKey = Base64.getDecoder().decode(pubKeyString);
        // 加密useBC
        byte[] encryptedDataBC = RSAUtils.encryptUseBC(srcText.getBytes("UTF-8"), pubKey);

        // 解密useBC
        RSAKey priKey = keyService.get(macId);
        byte[] srcDataBC = RSAUtils.decryptUseBC(encryptedDataBC, priKey.getRsaPrivateKey());

        Assert.assertEquals(srcText, new String(srcDataBC, "UTF-8"));
    }

}
