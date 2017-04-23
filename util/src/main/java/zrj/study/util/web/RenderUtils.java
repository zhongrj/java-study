package zrj.study.util.web;

import zrj.study.util.json.JsonUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Http 数据回写工具
 * @author qinrui@yonyou.com
 * @date 2016/7/5
 */
public class RenderUtils {
    /**
     * 客户端返回JSON字符串
     * @param response
     * @param object
     * @return
     */
    public static String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JsonUtils.toJsonString(object), "application/json", true);
    }

    /**
     * 客户端返回JSON字符串
     * @param response
     * @param object
     * @return
     */
    public static String renderString(HttpServletResponse response, Object object, boolean resetResp) {
        return renderString(response, JsonUtils.toJsonString(object), "application/json", resetResp);
    }

    /**
     * 客户端返回字符串
     * @param response
     * @param string
     * @return
     */
    public static String renderString(HttpServletResponse response, String string, String type, boolean resetResp) {
        try {
            if (resetResp) {
                response.reset();
            }
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

}
