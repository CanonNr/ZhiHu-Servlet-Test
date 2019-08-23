package cn.lksun.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class JdbcUtil{

    private static DataSource ds;

    static {
        InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pp = new Properties();
        try {
            pp.load(is);
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

//    public static void main(String[] args) throws Exception {
//        InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        Properties pp = new Properties();
//
//        pp.load(is);
//        ds = DruidDataSourceFactory.createDataSource(pp);
//        Connection conn = ds.getConnection();
//        Statement st = conn.createStatement();
//        String sql = "SELECT * FROM users";
//        ResultSet res = st.executeQuery(sql);
//        res.next();
//        String username = res.getString("username");
//        System.out.println(username);
//    }
}




