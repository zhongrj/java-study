package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.zzone.core.dao.SequenceDao;
import zrj.study.zzone.core.entity.Sequence;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/26
 */
@Service
@Transactional(readOnly = true)
public class SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    /**
     * 获取下一个id（AutoCommit）
     * @param id 标识
     * @return 下一个id
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int getNext(String id) {
        while (true) {
            Sequence sequence = sequenceDao.get(id);

            // 无则新建
            if (null == sequence) {
                sequence = new Sequence();
                sequence.setId(id);
                sequence.setCurrent(0);
                sequenceDao.insert(sequence);
            }

            // 更新
            if (sequenceDao.update(sequence) > 0) {
                return sequence.getCurrent() + 1;
            }
        }
    }

}
