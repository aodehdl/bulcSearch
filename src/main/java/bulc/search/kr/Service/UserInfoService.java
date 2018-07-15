package bulc.search.kr.Service;

import bulc.search.kr.entity.UserInfo;
import bulc.search.kr.entity.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;


    // 로그인
    public UserInfo login(String userId, String password){
        UserInfo user = userInfoRepository.findOne1ByUserId(userId);
        // 로그인 정보가 있으면 패스워드 비교 후 빈값리턴
        // 회원가입시 회원가입 후 회원정보 리턴
        if(user != null){
            if(!password.equals(user.getPassword())){
                user=null;
            }
        }else{
            userInfoRepository.save(UserInfo.builder()
                    .userId(userId)
                    .password(password)
                    .build());
            user = userInfoRepository.findOne1ByUserId(userId);
        }

        return user;
    }
}
