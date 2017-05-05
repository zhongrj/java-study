package zrj.study.zzone.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import zrj.study.util.string.IdGen;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
public abstract class BaseEntity {

    private String id;

    private Date createDate;

    private Date updateDate;

    private int delFlag;    // 删除标识 0正常 1删除

    public void generateUUID() {
        id = IdGen.uuid();
    }

    public void preInsert() {
        delFlag = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonIgnore
    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }
}
