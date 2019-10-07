package test;

import org.junit.Test;
import utils.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestC3P0 {
    @Test
    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("INSERT INTO user VALUES(7,'tom','123','tom@163.com','2015-09-28')");
            ps.executeUpdate();
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            C3P0Util.release(conn, ps, (ResultSet)null);
        }
        System.out.println("succeed!");
    }

}
