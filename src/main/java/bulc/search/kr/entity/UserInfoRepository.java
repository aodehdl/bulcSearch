package bulc.search.kr.entity;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    List<UserInfo> findOne1ByUserIdAndPassword(String userId, String password);
}
