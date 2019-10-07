package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Util {
    private static DataSource dataSource = new ComboPooledDataSource();

    public C3P0Util() {
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException var1) {
            throw new RuntimeException("服务器错误");
        }
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            conn = null;
        }

    }
}
