package bulc.search.kr.Controller;

import bulc.search.kr.Service.BookJpaService;
import bulc.search.kr.Service.feign.BookService;
import bulc.search.kr.dto.BookSearchDto;
import bulc.search.kr.entity.BookHistory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class BooksController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookJpaService bookJpaService;

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
    @RequestMapping(value = "/book/bookSearch", method= RequestMethod.POST)
    public String bookSearch(@ModelAttribute BookSearchDto.Req req, Model model) {
        log.info("bookSearch");

        req.setSize(30);

        BookSearchDto.Res res = bookService.getBook(req.getQuery(),  req.getSort(), req.getCategory(), req.getTarget(), req.getPage(), 30);

        // 실제 보여줄 목록이 없다면 검색결과가 없다고 판단
        if(res.getMeta().getPageableCount() > 0){
            res.getMeta().setPage(req.getPage());
            res.getMeta().setSize(30);

            // 날짜 형식 변경
            for(BookSearchDto.Res.Document temp : res.getDocuments()){
                //yyyy-mm-dd
                temp.setDatetime(temp.getDatetime().substring(0,10));
            }
        }

        //최근검색 저장
        bookJpaService.bookHistoryAdd(req);

        model.addAttribute("result", res);


        return "/book/bookSearch";
    }

    /**
     * 책 상세화면 열기
     * @return
     */
    @RequestMapping(value = "/book/bookDetail", method= RequestMethod.POST)
    public String bookDetail(@ModelAttribute BookSearchDto.Req req, Model model) {
        log.info("bookDetail");

        BookSearchDto.Res res = bookService.getBook(req.getQuery(),  req.getSort(), req.getCategory(), req.getTarget(), req.getPage(), 30);
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

    /**
     * 최근 검색어
     * @return
     */
    @RequestMapping(value = "/book/bookHistory", method= RequestMethod.GET)
    public String boohistory(@ModelAttribute BookSearchDto.Req req, Model model) {
        log.info("bookHistory");

        req.setSize(30);

        List<BookHistory> result = bookJpaService.getBookHistory(req);

        model.addAttribute("result", result);

        log.info("result : {}", result);

        return "/book/bookHistory";
    }
}
