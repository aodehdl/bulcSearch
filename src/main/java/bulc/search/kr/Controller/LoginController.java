package bulc.search.kr.Controller;

import bulc.search.kr.Service.UserInfoService;
import bulc.search.kr.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 로그인 페이지 열기
     * @return
     */
    @RequestMapping(value = "/login/loginView", method= RequestMethod.GET)
    public String index() {
        return "/login/loginView";
    }

    /**
     * 로그인
     * @return
     */
    @RequestMapping(value = "/login/login", method= RequestMethod.POST)
    public String login(Model model, HttpServletRequest req,
                        @RequestParam(name = "userId") String userId,
                        @RequestParam(name = "password") String password) {
        UserInfo user = userInfoService.login(userId, password);
        if(user==null){
            log.info("비밀번호가 다름");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }

        return "/login/loginView";
    }
}
