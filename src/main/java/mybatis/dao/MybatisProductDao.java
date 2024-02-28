package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionBean;
import mybatis.dto.CateDto;
import mybatis.dto.ProductDto;

public class MybatisProductDao {

	
	private SqlSessionFactory sessionFactoty = SqlSessionBean.getSessionFactory();
	
	public List<CateDto> getCategories(){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> selectpro(){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectpro");
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> selectcategory(String category){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectcategory",category);
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> likeselect(String pname){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.likeselect",pname);
		sqlSession.close();
		return list;
	}
	
//	public Map<String, Integer> pricetable(){
//		Map<String, Integer> result = new HashMap<>();
//		SqlSession sqlSession = sessionFactoty.openSession();
//		List<ProductDto> list = sqlSession.selectList("tblproduct.pricetable");
//		sqlSession.close();
//		return result;
//	}
	public List<ProductDto> search(Map<String,Object> map){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<ProductDto> list= sqlSession.selectList("tblproduct.search",map);
		sqlSession.close();
		return list;
	}
	
	
}
