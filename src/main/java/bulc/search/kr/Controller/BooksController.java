package bulc.search.kr.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MAIN-PC on 2018-07-11.
 */
@Slf4j
@Controller
public class BooksController {
    /**
     * 책검색 화면 열기
     * @return
     */
    @RequestMapping(value = "/book/SearchView", method= RequestMethod.GET)
    public String searchView() {
        log.info("searchView");

        return "/book/SearchView";
    }
}
