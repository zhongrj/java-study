package zrj.study.zzone.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/28
 */
public class PageModel extends BaseModel {

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码格式不正确")
    private int pageNo;

    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空")
    @Min(value = 1, message = "每页数量不正确")
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
