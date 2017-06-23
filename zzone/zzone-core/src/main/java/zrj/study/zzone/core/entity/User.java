package zrj.study.zzone.core.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class User extends BaseEntity {

    public final static String TYPE_USER = "0";         // 普通用户
    public final static String TYPE_MEMBER = "1";       // 会员用户
    public final static String TYPE_ADMIN = "9";        // 管理用户
    public static final String STATUS_NORMAL = "0"; // 正常状态
    public static final String STATUS_FREEZED = "1"; // 冻结状态
    public static final String STATUS_BLACKLIST = "2"; // 黑名单状态

    @NotEmpty(message = "用户名不能为空")
    private String account;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String name;
    private String mobile;
    private String email;

    private String type;
    private String status;

    private String token;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
