package zrj.study.zzone.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.security.RSAUtils;
import zrj.study.zzone.core.common.cache.CacheManage;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.entity.RSAKey;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 密钥Service
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
@Service
@Transactional(readOnly = true)
public class KeyService extends BaseService {

    private static final String CACHE_KEY = "key";

    static {
        CacheManage.put(CACHE_KEY, new HashMap<String, RSAKey>()); // 需要定时清理
    }

    private static Map<String, RSAKey> getKeyMap() {
        return (Map<String, RSAKey>) CacheManage.get(CACHE_KEY);
    }

    /**
     * 获取密钥
     *
     * @param id 密钥id
     */
    public RSAKey get(String id) {
        RSAKey rsaKey = getKeyMap().get(id);
        if (null == rsaKey) {
            throw new ZzoneException("密钥已失效");
        }
        return rsaKey;
    }


    /**
     * 删除密钥
     *
     * @param id 密钥id
     */
    public void remove(String id) {
        getKeyMap().remove(id);
    }

    /**
     * 生成一对RSAKey
     *
     * @return RSAKey
     */
    public RSAKey newKey(String source) {
        try {
            RSAKey rsaKey = new RSAKey();
            KeyPair keyPair = RSAUtils.newKeyPair("web".equals(source));
            rsaKey.setRsaPublicKey((RSAPublicKey) keyPair.getPublic());
            rsaKey.setRsaPrivateKey((RSAPrivateKey) keyPair.getPrivate());
            rsaKey.preInsert();
            rsaKey.setCreateDate(new Date());
            getKeyMap().put(rsaKey.getId(), rsaKey);
            return rsaKey;
        } catch (Exception e) {
            throw new ZzoneException("生成密钥异常", e);
        }
    }

}
