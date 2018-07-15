package bulc.search.kr.Service.feign;

import bulc.search.kr.dto.BookSearchDto;
import bulc.search.kr.entity.BookHistory;
import bulc.search.kr.entity.BookHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookJpaService {
    @Autowired
    private BookHistoryRepository bookHistoryRepository;
    public List<BookHistory> bookHistoryAdd(BookSearchDto.Req dto){
        bookHistoryRepository.save(BookHistory.builder()
                .userId("test")
                .query(dto.getQuery())
                .size(dto.getSize())
                .sort(dto.getSort())
                .target(dto.getTarget())
                .build());

        return bookHistoryRepository.findFirst10ByUserId("test", new Sort(Sort.Direction.DESC, "regDttm"));
    }
}
