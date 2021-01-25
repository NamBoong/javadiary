package jdbcTest;

import java.sql.*;

public class DAOTest2 {

	public static void main(String[] args) {
		User2 u = new User2("ff22f", "���ü�", "1234", "aaa@aaa.com");
		System.out.println(u);
		
		insertUser(u); // ��ü u�� ����� ���� DB�� user_info���̺� insesrt�ϴ� �޼���
	}
	
	static int insertUser(User2 u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String url = "jdbc:student://localhost:1521/xe"; // ���⿡ ���� �����ұ�?
			String id = "student";
			String pw = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("���� ������ �ߴٴ� ���� �����!d^0^b");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			String sql = "insert into member1 values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.id);
			pstmt.setString(2, u.name);
			pstmt.setString(3, u.password);
			pstmt.setString(4, u.email);
			
			pstmt.executeUpdate();
			
			System.out.println("�سµ�! ���ε� �Ϸ�! \\^0^/");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("���̺� �Է� ������...�Ф�");
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
					pstmt.close();
				}
				catch(SQLException sqle) {
				}
			}
		}
		return 0;
		 
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
