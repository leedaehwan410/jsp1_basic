package project.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class BuyVo {
    
    private int buy_idx;
    private String customid;
    private String pcode;
    private int quantity;
    private Date buy_date;

}