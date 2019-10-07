package utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtil {
    private static DataSource ds = null;
    static{
        Properties prop = new Properties();
        System.out.println("dbutils");
        try {
            //class.getClassLoader().getResourceAsStream() 通过类加载器在classPath目录下获取资源.并且是以流的形式
            prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dhcp/dbcpconfig.properties"));//根据DBCPUtil的classes的路径，加载配置文件
            ds = BasicDataSourceFactory.createDataSource(prop);//得到一个数据源
        } catch (Exception e) {
//            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化错误，请检查配置文件");
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器忙。。。");
        }
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs){
        //关闭资源
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
