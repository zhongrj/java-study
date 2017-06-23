package zrj.study.zzone.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import zrj.study.util.web.RenderUtils;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.SessionService;
import zrj.study.zzone.web.model.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * 权限拦截器
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/19
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (null == token) {
            RenderUtils.renderString(response, Result.UNLOGIN);
            return false;
        }

        User user = sessionService.getUserByToken(token);
        if (null == user) {
            RenderUtils.renderString(response, Result.UNLOGIN);
            return false;
        }

        // /console/**路径需要管理员用户
        if (Pattern.matches("/console/.*", request.getRequestURI())) {
            if (!User.TYPE_ADMIN.equals(user.getType())) {
                RenderUtils.renderString(response, Result.UNAUTH);
            }
        }

        user.setToken(token);
        request.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
