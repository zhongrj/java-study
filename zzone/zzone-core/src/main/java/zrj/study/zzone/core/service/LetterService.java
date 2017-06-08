package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zrj.study.zzone.core.dao.LetterDao;
import zrj.study.zzone.core.entity.Letter;
import zrj.study.zzone.core.entity.User;

/**
 * 站内信Service
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
@Service
public class LetterService {

    @Autowired
    private LetterDao letterDao;

    public void notice(User user, Letter letter) {

    }
}
