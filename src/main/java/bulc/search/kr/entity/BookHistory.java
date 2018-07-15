package bulc.search.kr.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Getter
@Entity(name = "bookhistory")
@IdClass(BookHistoryKey.class)
public class BookHistory {

    @Id
    @Column
    private String userId;

    @Id
    @Column
    private String query;

    @Column
    private String sort;

    @Column
    private Integer size;

    @Column
    private String target;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar regDttm;


    @Builder
    public BookHistory(String userId, String query, String sort, Integer size, String target )
    {
        this.userId = userId;
        this.query = query;
        this.size = size;
        this.target = target;
        this.sort = sort;
    }

    public BookHistory(){

    }

}
