package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOTest3 {

	public static void main(String[] args) {
		User3 u = new User3("ff22f", "ȫ�浿", "4444", "aaa@aaa.com");
		System.out.println(u);
		
		//��ü u�� ����� user_id�� ������ ���� ������ update�ϴ� �޼���
		updateUser(u);
	}
	
	static int updateUser(User3 u) {
		// conn pstmt �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// sql�� url, id, pwd �Է�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "student";
			String pwd = "1234";
			
			// sql���� ������ ����ϴ� �����ͺ��̽� ����
			// �������� �����϶�� �ֽ� ��α��� 
			// com.mysql.jdbc.Driver�� jdbc.driver.OracleDrvier���� �ֽŹ����̴�!
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("���� ����! ^-^b");	

			pstmt = conn.prepareStatement("update USER_INFO set PASSWORD=?, NAME=?, EMAIL=? where USER_ID=?");
			
			// ������ ? ������� 1�� 2�� 3�� 4���� �ȴ�. ��, ���� Ŀ������ PASSWORD�� 1���� �ǰ�, USER_ID�� 4���� �ȴ�.
			pstmt.setString(4, u.id);
			pstmt.setString(1, u.password);
			pstmt.setString(2, u.name);
			pstmt.setString(3, u.email);
			
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("���� ���ФФ�");
			return 0;

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
	}
}


// !!!! �� ���� �̸��� class�� ���������� Ȯ���ϱ�!
class User3{
	String id;
	String name;
	String password;
	String email;
	
	public User3(String id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
