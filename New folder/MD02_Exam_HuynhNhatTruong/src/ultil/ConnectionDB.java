package ultil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_management_db",
                    "root",
                    "Weak"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement call) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (call != null) {
            try {
                call.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}
