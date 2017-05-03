package zrj.study.zzone.core.dao;

import zrj.study.zzone.core.entity.Option;

import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/2
 */
public interface OptionDao extends BaseDao<Option> {

    List<Option> getList(String type);

}
