package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.string.StringUtils;
import zrj.study.zzone.core.dao.OptionDao;
import zrj.study.zzone.core.entity.Option;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 选项卡Service
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/2
 */
@Service
@Transactional(readOnly = true)
public class OptionService {

    @Autowired
    private OptionDao optionDao;

    public List<Option> getOptionByType(String type) {
        return optionDao.getList(type);
    }

    public Map<String, List<Option>> getOptionByTypes(String types) {
        Map<String, List<Option>> options = new HashMap<>();
        if (StringUtils.isNotBlank(types)){
            for (String type : types.split("\\s*,\\s*")) {
                options.put(type, getOptionByType(type));
            }
        }
        return options;
    }

}
