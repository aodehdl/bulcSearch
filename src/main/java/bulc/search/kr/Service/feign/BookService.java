package bulc.search.kr.Service.feign;

import bulc.search.kr.Config.kakaoDevConfig;
import bulc.search.kr.dto.BookSearchDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient( name = "kakaoBookSearch", url="${kakao.url}", configuration = kakaoDevConfig.class )
public interface BookService {
    /**
     *
     * 카카오 책 검색을 이용하여 목록 가져오기
     *
     * */
    @RequestMapping( method = RequestMethod.GET, value = "/v2/search/book", produces={"application/json; charset=UTF-8"})
    BookSearchDto.Res getBook(
            @RequestParam("query") String query,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "target", required = false) String target,
            @RequestParam(value = "page", required = false) String page);

}
