package jdbcTest;

import java.sql.*;

public class DAOTest2 {

	public static void main(String[] args) {
		User2 u = new User2("ff22f4", "���ü�", "1234", "aaa@aaa.com");
		System.out.println(u);
		
		System.out.println(insertUser(u)); // ��ü u�� ����� ���� DB�� user_info���̺� insesrt�ϴ� �޼���
	}
	
	static int insertUser(User2 u) {
		// �̰� ���߿� �����Ҳ���. �� �ؿ� finally ����.
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			//url �����
			// jdbc:oracle:thin:  <-������� ����
			// @localhost:####    <-����Ŭ���� ��Ʈ ��ȣ�� ####�� �־��ֱ�
			// :##                <-����Ŭ���� sid ###�� �־��ֱ�
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ���⿡ ���� �����ұ�?
			String id = "student";
			String pw = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("���� ������ �ߴٴ� ���� �����!d^0^b");
			
			// ****������� ����*****
			
			
			// sql ����(values�� 4�� ����� 4���� �ְڴٴ� ��)
			// ��user_id�� �ٸ��� �������� ���Ƶ� ����� ���ٴ°� �� �� �ִ�.
			// ***����! sysdate�� ���� ���� �����ʾƵ� �Ǵ°���?
			String sql = "insert into user_info(user_id, password, name, email, in_date, up_date)"
						+ "values(?,?,?,?,sysdate,sysdate)";
			
			// sql �̸� ������
			pstmt = conn.prepareStatement(sql);
			// ������ values 4�� ��������� 4���� ���� ������ �����ش�.
			pstmt.setString(1, u.id);
			pstmt.setString(2, u.password);
			pstmt.setString(3, u.name);
			pstmt.setString(4, u.email);
			// ���� ������Ʈ ����(������Ʈ �� ������ result�� �ִ´�)
			result = pstmt.executeUpdate();
			
			System.out.println("������ �߰� ����!d^0^b");
		}
		catch(Exception e) {
			System.out.println("������ �߰��� �����ߴ٤Ф�");
			e.printStackTrace();
		}
		//���� ���� ���� �� �� ������ �����ؾ��Ѵ�!!!!!!!
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}
				//1�� : PreparedStatement ��ü ����
				catch(SQLException sqle) {
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}
				//2�� : Connection ����
				catch(SQLException sqle) {
				}
			}
		}
		
		return result;
	}

} // end of class

class User2{
	String id;
	String name;
	String password;
	String email;
	
	public User2(String id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
}
