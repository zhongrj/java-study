package zrj.study.zzone.core.dao;

import org.apache.ibatis.annotations.Param;
import zrj.study.zzone.core.entity.User;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public interface UserDao extends BaseDao<User> {

    int countByField(@Param("field") String field, @Param("value") String value);

}
