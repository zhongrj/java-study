package zrj.study.zzone.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class BaseModel {

    @NotEmpty(message = "mac地址不能为空")
    private String macId;

    @NotEmpty(message = "source不能为空")
    private String source;

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
