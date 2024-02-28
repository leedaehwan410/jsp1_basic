package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.BuyVo;
import project.vo.CustomerVo;
import project.vo.ProductVo;

public class TblProductDao {
    
    public static final String URL ="jdbc:oracle:thin:@localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //2. 카테고리로  검색하기 
	public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n" + 
                     "WHERE CATEGORY =? \r\n" +
                     "ORDER BY PNAME";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
            psmt.setString(1, category);
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  //조회결과는 n행 가능성 예측
			    list.add(new ProductVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByCategory 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    //3. 상품명으로 검색하기 (유사검색-> `검색어가 포함된 상품명`을 조회하기)
	public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n"
                + "WHERE PNAME LIKE '%' || ? || '%' \r\n"      //like는 유사 비교. % 기호 사용
                + "ORDER BY CATEGORY";
        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
		{
            ps.setString(1, pname);
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next()) {
			    list.add(new ProductVo(rs.getString(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByPname 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    // 상품 가격표 Map 에 저장하기
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,price from tbl_product";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  
			   map.put(rs.getString(1),         //key
                       rs.getInt(2));           //value
		    }
        }catch(SQLException e){
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }

        return map;
    }
    
    
 public List<ProductVo> selectAll() {
    	
        List<ProductVo> list = new ArrayList<>();
        String sql ="SELECT * from TBL_PRODUCT"; 
          
        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
		{
            
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next()) {
			    list.add(new ProductVo(rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4)));
              
		    }
        }catch(SQLException e){
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
        }
		return list;
	}

 //리턴 타입 int: 정상 insert 완료하면 1 리턴 , 그렇지 않으면 0
 public int insert(ProductVo vo){
     // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
     String sql="insert into tbl_product(pcode,category,pname,price) " + 
                 "values (?, ?, ?, ?)";
     
     int result = 0;
     try (Connection connection = getConnection();       //auto close
         PreparedStatement pstmt = connection.prepareStatement(sql);)
         {   
             //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
             pstmt.setString(1, vo.getPcode());
             pstmt.setString(2, vo.getCategory());
             pstmt.setString(3, vo.getPname());
             pstmt.setInt(4, vo.getPrice());
           result =  pstmt.executeUpdate();	//정상 insert 완료하면 1 리턴 ,그렇지 않으면 0 
     } catch (SQLException e) {
         System.out.println("insert 실행 예외 발생 : " + e.getMessage());
     }
     return result;
 }
}
