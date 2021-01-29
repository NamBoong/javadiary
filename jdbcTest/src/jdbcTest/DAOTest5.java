package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOTest5 {

	public static void main(String[] args) {
		// ��ü u�� ����� user_id�� ������ ���� ������ delete�ϴ� �޼���

		deleteUser("ff22f");
		
	}
	static int deleteUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "student";
			String pw = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("���� ����!");
			
			String sql = "delete from USER_INFO where USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			System.out.println("���� ����!");
			
			int result = pstmt.executeUpdate();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� ���ФФ�");
		}
		finally {
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
		return 0;
	}
}