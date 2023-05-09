package DruidDemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Author: qjc
 * @Date: 2023/5/9 11:31
 * @Description: TODO
 **/
public class Base {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Test
    public void testHard() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        // 连接参数
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);


        // 非必需参数。初始化连接数量，最大连接数量....
        dataSource.setInitialSize(5); // 初始化连接数量
        dataSource.setMaxActive(10); // 最大连接数量

        // 获取连接
        DruidPooledConnection connection = dataSource.getConnection();


        // 数据库crud


        // 回收连接
        connection.close();

    }
}
