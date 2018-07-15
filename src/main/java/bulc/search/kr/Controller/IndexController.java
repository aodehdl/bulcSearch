package bulc.search.kr.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class IndexController {
    /**
     * 책검색 화면 열기
     * @return
     */
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String index() {
        return "/book/SearchView";
    }

}
