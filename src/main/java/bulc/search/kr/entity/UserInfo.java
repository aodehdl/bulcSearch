package bulc.search.kr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Entity(name = "userInfo")
public class UserInfo {

    @Id
    @Column
    private String userId;

    @JsonIgnore
    @Column(length = 128, updatable = false, nullable = false)
    private String password;


    private Timestamp regDttm;


    @Builder
    public UserInfo(String userId, String password)
    {
        this.userId = userId;
        this.password = password;
    }

    public UserInfo(){

    }

}
