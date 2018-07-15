package bulc.search.kr.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by MAIN-PC on 2018-07-15.
 */
@Slf4j
public class BookInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptor > preHandle");
        HttpSession session = request.getSession();
        //세션이 없으면 로그인 페이지로 이동
        if(!ObjectUtils.isEmpty(session.getAttribute("user"))){
            log.info("dd :{}", ObjectUtils.isEmpty(session.getAttribute("user")));
            response.sendRedirect("/login/loginView");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor > postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        log.info("Interceptor > afterCompletion" );
    }
}
