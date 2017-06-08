package zrj.study.zzone.core.common.aware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import zrj.study.util.io.IOUtils;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
@Component
public class EnvironmentCheck implements BeanFactoryAware {

    private BeanFactory beanFactory;

    private Logger logger = LoggerFactory.getLogger(EnvironmentCheck.class);

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        try {
            check();
        } catch (Throwable t) {
            logger.error("启动检查失败", t);
        }
    }


    @Autowired
    private Environment env;

    private void check() throws Exception {

        // 检查相关目录是否创建
        IOUtils.createDirIfNotExist(env.getProperty("upload.path.img"));

    }


}
