package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.string.StringUtils;
import zrj.study.zzone.core.dao.DictDao;
import zrj.study.zzone.core.entity.Dict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典Service
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/2
 */
@Service
@Transactional(readOnly = true)
public class DictService {

    @Autowired
    private DictDao dictDao;

    public List<Dict> getDictByType(String type) {
        return dictDao.getList(type);
    }

    /**
     * @param types 以,分隔多个type
     */
    public Map<String, List<Dict>> getDictByTypes(String types) {
        Map<String, List<Dict>> dicts = new HashMap<>();
        if (StringUtils.isNotBlank(types)){
            for (String type : types.split("\\s*,\\s*")) {
                dicts.put(type, getDictByType(type));
            }
        }
        return dicts;
    }

}
