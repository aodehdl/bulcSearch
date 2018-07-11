package bulc.search.kr.Controller;

import bulc.search.kr.Service.feign.BookService;
import bulc.search.kr.dto.BookSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MAIN-PC on 2018-07-11.
 */
@Slf4j
@Controller
public class BooksController {
    @Autowired
    private BookService bookService;

    /**
     * 책검색 화면 열기
     * @return
     */
    @RequestMapping(value = "/book/SearchView", method= RequestMethod.GET)
    public String searchView() {
        log.info("searchView");

        return "/book/SearchView";
    }

    /**
     * 책검색 화면 열기
     * @return
     */
    @RequestMapping(value = "/book/bookSearch", method= RequestMethod.GET)
    public String searchView(Model model) {
        log.info("bookSearch");

        BookSearchDto.Res res = bookService.searchBook("이효리", "","","");

        model.addAttribute("result", res);

        log.info("result : {}", res);

        return "/book/bookSearch";
    }
}
