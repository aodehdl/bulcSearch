package bulc.search.kr.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;

@Getter
@Entity(name = "bookMark")
@IdClass(BookMarkKey.class)
public class BookMark {

    @Id
    @Column
    private String userId;

    @Id
    @Column
    private String barcode;

    @Column
    private String query;

    @Column
    private String sort;

    @Column
    private Integer size;

    @Column
    private String target;

    @Column
    //삭제 여부
    private String delYn;

    private Timestamp regDttm;


    @Builder
    public BookMark(String userId, String barcode, String query, String sort, Integer size, String target, String delYn )
    {
        this.userId = userId;
        this.barcode = barcode;
        this.query = query;
        this.size = size;
        this.target = target;
        this.sort = sort;
        this.delYn = delYn;
    }

    public BookMark(){

    }

}
