package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Util {
    //得到一个数据源
    private static DataSource dataSource = new ComboPooledDataSource();
    //返回一个数据源
    public static DataSource getDataSource() {
        return dataSource;
    }
    //得到一个连接对象
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("服务起错误");
        }

    }
    //释放资源
    public void release(Connection conn, PreparedStatement stmt, ResultSet rs){

        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }

    }
}
