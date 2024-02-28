package mybatis.dto;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
public class CustomerDto {
	
	private String customid;
    private String name;
    private String email;
    private int age;
    private Date reg_date;
}
