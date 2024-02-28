package mybatis;



import java.util.List;



import mybatis.dao.MybatisBuyDao;
import mybatis.dao.MybatisCustomerDao;
import mybatis.dao.MybatisProductDao;
import mybatis.dto.BuyDto;
import mybatis.dto.CustomBuyDto;
import mybatis.dto.CustomerDto;
import mybatis.dto.ProductDto;


public class MybatisSessionTest {
	static MybatisCustomerDao daoc = new MybatisCustomerDao();
	static MybatisProductDao daop = new MybatisProductDao();
	static MybatisBuyDao dao = new MybatisBuyDao();

	public static void main(String[] args) {
		System.out.println("dao 객체 : " + dao);
		insert();
		productprice();
		delete(1442);
		selectAll();
		selectpro();
		selectcategory("B2");
		likeselect("사과");
		selectid();
		join();
		del("jaewon11");
		allCustomer();
		modify();
		

	}

	private static void insert() {
		int result = dao.insert(new BuyDto(0, "mina012" ,"CJBAb12g", 4, null));
		System.out.println("반영된 행 개수 : " + result);
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);
	}
	
	private static List<CustomBuyDto> productprice() {
		List<CustomBuyDto> list = dao.productprice("mina012");
		System.out.println(list);
		return list;
	}
	
	private static void delete(int buyidx) {
		int result = dao.delete(buyidx);
		System.out.println(result);
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);
	}
	
	
	private static void selectAll() {
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);

	}
	
	private static void selectpro() {
		
		List<ProductDto> list = daop.selectpro();
		System.out.println(list);
		
	}
	
	private static List<ProductDto> selectcategory(String category) {
		List<ProductDto> list = daop.selectcategory(category);
		System.out.println(list);
		return list;
	}
	
	private static List<ProductDto> likeselect(String pname) {
		List<ProductDto> list = daop.likeselect(pname);
		System.out.println(list);
		return list;
	}
	
	

	 
	
	private static List<CustomerDto> selectid(){
		List<CustomerDto> list = daoc.selectid("mina012");
		System.out.println(list);
		return list;
	}
	
	private static void join() {
		int result = daoc.join(new CustomerDto("jaewon11", "재원", "jaewon@naver.com", 30, null));
		System.out.println(result);
		List<CustomerDto> list = daoc.allCustomer();
		System.out.println(list);
		
	}
	
	private static void modify() {
		daoc.modify(new CustomerDto("mina012", null, "dhfl@dhsdl", 100, null));
		List<CustomerDto> list2 = daoc.allCustomer();
		System.out.println(list2);
		

	}
	
	private static void del(String customid) {
		int result = daoc.del(customid);
		System.out.println(result);
		List<CustomerDto> list = daoc.allCustomer();
		System.out.println(list);
		
	}
	
	private static List<CustomerDto> allCustomer() {
		List<CustomerDto> list = daoc.allCustomer();
		System.out.println(list);
		return list;
		
	}
	
	
	
	
	

}
