package zrj.study.zzone.core.dao;

import org.apache.ibatis.annotations.Param;
import zrj.study.zzone.core.entity.Session;
import zrj.study.zzone.core.entity.User;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
public interface SessionDao extends BaseDao<Session> {

    User getUserByToken(String token);

    int deleteByUserId(@Param("userId") String userId);
}
