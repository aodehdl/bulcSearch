package bulc.search.kr.Controller;

import bulc.search.kr.Service.feign.BookService;
import bulc.search.kr.dto.BookSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ListUtils;

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
     * 책검색
     * @return
     */
    @RequestMapping(value = "/book/bookSearch", method= RequestMethod.GET)
    public String bookSearch(Model model) {
        log.info("bookSearch");

        BookSearchDto.Res res = bookService.getBook("이효리", "","","", "");

        model.addAttribute("result", res);

        log.info("result : {}", res);

        return "/book/bookSearch";
    }

    /**
     * 책 상세화면 열기
     * @return
     */
    @RequestMapping(value = "/book/bookDetail", method= RequestMethod.POST)
    public String bookDetail(@ModelAttribute BookSearchDto.Req req, Model model) {
        log.info("bookDetail");

//        BookSearchDto.Res res = bookService.getBook(req.getQuery(),  req.getSort(), req.getCategory(), req.getTarget(), req.getPage());
        BookSearchDto.Res res = bookService.getBook("이효리",  req.getSort(), req.getCategory(), req.getTarget(), req.getPage());
        BookSearchDto.Res.Document result = null;

        // 실제 보여줄 목록이 없다면 검색결과가 없다고 판단
        if(res.getMeta().getPageableCount() > 0){
            // 목록을 조회하여 BarCode 값으로 상세목록에 보여줄 책을 찾음
            for(BookSearchDto.Res.Document temp : res.getDocuments()){
                if(StringUtils.defaultIfEmpty(req.getBarcode(), "").equals(temp.getBarcode())){
                    result = temp;
                }
            }
        }

        model.addAttribute("result", result);

        log.info("result : {}", result);

        return "/book/bookDetail";
    }
}
