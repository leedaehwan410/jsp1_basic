package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionBean;
import mybatis.dto.BuyDto;
import mybatis.dto.CustomBuyDto;


public class MybatisBuyDao {

	private SqlSessionFactory sessionFactoty = SqlSessionBean.getSessionFactory();

	public MybatisBuyDao() {
		//테스트 db 연결 : 나중에는 지웁니다.
		//SqlSession sqlSession = sessionFactoty.openSession();
		//System.out.println("db 연결 및 sql 실행 객체 : " + sqlSession);
	}
	//SqlSession 객체 insert, update, delete, select 메소드는 SQl을 실행합니다.
	//			ㄴ 첫번째 인자는 SQL매퍼 파일 namespace속성.id속성
	//			ㄴ 두번째 인자는 SQL 실행에 파라미터가 있으면 작성합니다.
	
	public List<BuyDto> selectAll(){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<BuyDto> list = sqlSession.selectList("tblbuy.selectAll");
		sqlSession.close();
		return list;
	}
	
	public int insert(BuyDto vo) {
		SqlSession sqlSession = sessionFactoty.openSession();
		int result = sqlSession.insert("tblbuy.insert",vo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int update(Map<String, Integer> map) {
		SqlSession sqlSession = sessionFactoty.openSession();
		int result = sqlSession.update("tblbuy.update",map);
		sqlSession.commit();
		sqlSession.close();
		return result;
		
	}
	
	public int delete(int buyidx) {
		SqlSession sqlSession = sessionFactoty.openSession();
		int result = sqlSession.delete("tblbuy.delete",buyidx);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<CustomBuyDto> productprice(String customid) {
		SqlSession sqlSession = sessionFactoty.openSession();
		List<CustomBuyDto> list = sqlSession.selectList("tblbuy.productprice",customid);
		sqlSession.close();
		return list;
	}
}
