package zrj.study.zzone.core.entity;

import java.util.Date;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
public class Session extends BaseEntity {

    private String userId;
    private String token;
    private Date expireDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
