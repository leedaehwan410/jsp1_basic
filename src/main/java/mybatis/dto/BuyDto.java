package mybatis.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


//웹에서는 vo 단어 대신 dto(data transfer object) 많이 씁니다. 
//서블릿(컨트롤러), jsp(뷰) ,db 사이에서 데이터를 전달해주는 역할.

//마이바티스에서 매핑 할때 객체는 기본생성자가 있으면 기본생성자로 없으면 커스텀 생성자로 객체 생성.
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString

public class BuyDto {
	 
	private int Buy_idx;
	private String customid;
	private String Pcode;
	private int quantity;
	private Date buy_date;
}

