package bulc.search.kr.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookHistoryKey implements Serializable {
    private String userId;
    private String query;
}
