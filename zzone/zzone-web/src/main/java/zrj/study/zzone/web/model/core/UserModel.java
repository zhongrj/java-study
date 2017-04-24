package zrj.study.zzone.web.model.core;

import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.web.model.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class UserModel extends BaseModel {

    @Valid
    private User user;

    @NotNull(message = "user不能为空")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
