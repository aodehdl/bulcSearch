package bulc.search.kr.entity;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookHistoryRepository extends JpaRepository<BookHistory, String> {
    List<BookHistory> findFirst10ByUserId(String userId, Sort sort);
}
