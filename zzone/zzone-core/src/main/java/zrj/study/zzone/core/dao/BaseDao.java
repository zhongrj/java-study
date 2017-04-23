package zrj.study.zzone.core.dao;

import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
interface BaseDao<E> {

    E get(String id);

    E get(E e);

    List<E> list(E e);

    int update(E e);

    int insert(E e);

    int delete(String id);

    int delete(E e);
}
