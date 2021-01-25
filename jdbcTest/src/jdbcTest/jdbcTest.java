package jdbcTest;

import java.sql.*;

public class jdbcTest {

public static void main(String[] args) {

String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

String DB_USER = "student"; // DB�� userid�� pwd�� �˸°� ����

String DB_PASSWORD = "1234";

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String query = "SELECT sysdate FROM dual"; // �ý����� ��¥�� ����Ѵ�.

try {

// ����̹��� �ε��Ѵ�.

Class.forName("oracle.jdbc.driver.OracleDriver");

conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ �����Ѵ�.

stmt = conn.createStatement(); // Statement�� �����´�.

rs = stmt.executeQuery(query); // SQL���� �����Ѵ�.

while (rs.next()) {

String curDate = rs.getString(1);

System.out.println(curDate);

}

} catch ( Exception e ) {

e.printStackTrace();

} finally {

try {

rs.close();

stmt.close();

conn.close();

} catch ( SQLException e ) {}

}

} // main()�� ��

} // Ŭ������ ��
