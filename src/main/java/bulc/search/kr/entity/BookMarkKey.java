package bulc.search.kr.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookMarkKey implements Serializable {
    private String userId;
    private String barcode;
}
