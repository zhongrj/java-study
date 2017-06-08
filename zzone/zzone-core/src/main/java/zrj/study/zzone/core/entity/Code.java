package zrj.study.zzone.core.entity;

/**
 * 验证码
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/27
 */
public class Code extends BaseEntity {

    private String codeTxt;
    private int width;
    private int height;

    public String getCodeTxt() {
        return codeTxt;
    }

    public void setCodeTxt(String codeTxt) {
        this.codeTxt = codeTxt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
