package zrj.study.zzone.core.entity;

/**
 * 字典
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/2
 */
public class Dict extends BaseEntity{

    private String label;
    private String value;
    private String type;
    private String description;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
