package zrj.study.zzone.web.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class BaseModel {

    @NotEmpty(message = "mac地址不能为空")
    private String macId;

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }
}
