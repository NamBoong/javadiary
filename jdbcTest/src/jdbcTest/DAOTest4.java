package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOTest4 {

	public static void main(String[] args) {
		// 객체 u에 저장된 user_id와 동일한 행의 정보를 update하는 메서드
		selectUser("ff22f");
		
	}
	static User4 selectUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "student";
			String pw = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw);
			
			String sql = "select * from USER_INFO where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("user_id"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("email"));
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("테이블 호출 실패ㅠㅠ");
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(SQLException sqle) {
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}
				catch(SQLException sqle) {
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(SQLException sqle) {
				}
			}
		}
		
		return null;
	}
	class User4{
		String id;
		String name;
		String password;
		String email;
		
		public User4(String id, String name, String password, String email) {
			this.id = id;
			this.name = name;
			this.password = password;
			this.email = email;
		}
	}

}
