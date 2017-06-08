package zrj.study.zzone.core.entity;

import java.io.InputStream;

/**
 * 文件实体
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/7
 */
public class File extends BaseEntity {

    private String originName;
    private String storeName;
    private String type;
    private InputStream inputStream;

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
