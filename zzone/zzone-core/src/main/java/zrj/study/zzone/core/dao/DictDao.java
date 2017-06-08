package zrj.study.zzone.core.dao;

import zrj.study.zzone.core.entity.Dict;

import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/2
 */
public interface DictDao extends BaseDao<Dict> {

    List<Dict> getList(String type);

}
