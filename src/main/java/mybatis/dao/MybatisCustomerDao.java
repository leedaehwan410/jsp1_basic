package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionBean;
import mybatis.dto.CustomerDto;


public class MybatisCustomerDao {

	private SqlSessionFactory sessionFactoty = SqlSessionBean.getSessionFactory();

	public List<CustomerDto> selectid(String customid){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.selectid",customid);
		sqlSession.close();
		return list;
	}
	public int join(CustomerDto dto){
		SqlSession sqlSession = sessionFactoty.openSession();
		int result = sqlSession.insert("tblcustom.join",dto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public List<CustomerDto> modify(CustomerDto dto){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.modify",dto);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	public int del(String customid){
		SqlSession sqlSession = sessionFactoty.openSession();
		int result = sqlSession.delete("tblcustom.del",customid);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	public List<CustomerDto> allCustomer(){
		SqlSession sqlSession = sessionFactoty.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.allCustomer");
		sqlSession.close();
		return list;
	}



}

