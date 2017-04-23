package zrj.study.zzone.core.dao;

import zrj.study.zzone.core.entity.User;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public interface UserDao extends BaseDao<User> {

    int countByAccount(String account);

}
