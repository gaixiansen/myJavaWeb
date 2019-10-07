package test;

import bean.User;
import org.junit.Test;
import utils.DBCPUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestJDBC {
    @Test
    public void test1(){
        Connection conn= null;
        PreparedStatement statement= null;
        ResultSet resultSet= null;
        try {
            conn = DBCPUtil.getConnection();
            String sql = "select * from user";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            ArrayList<User> list = new ArrayList<>();
            while (resultSet.next()){
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("passwd"));
                u.setEmail(resultSet.getString("email"));
                u.setBirthday(resultSet.getDate("birthday"));
                list.add(u);
            }
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtil.release(conn,statement,resultSet);
        }
    }
}
