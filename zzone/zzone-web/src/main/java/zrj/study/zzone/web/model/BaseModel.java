package zrj.study.zzone.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class BaseModel {

    /**
     * 设备物理地址
     */
    @NotEmpty(message = "mac地址不能为空")
    private String macId;

    /**
     * 请求来源
     */
    @Pattern(regexp = "android|ios|web", message = "来源不合法")
    private String source;

    /**
     * 密钥id
     */
    private String keyId;

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}
