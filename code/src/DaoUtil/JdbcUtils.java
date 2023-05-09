package DaoUtil;

import DruidDemo.propertiesBase;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: qjc
 * @Date: 2023/5/9 16:23
 * @Description: 工具类
 **/
public class JdbcUtils {
    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();


    static {

        // 初始化
        Properties properties = new Properties();
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("mysqlCon.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {

        Connection connection = tl.get();

//        null
        if (connection == null) {
            connection = dataSource.getConnection();
            tl.set(connection);
        }

        return dataSource.getConnection();
    }

    public static void freeConnection() throws SQLException {

        Connection connection = tl.get();
        if (connection != null){
            tl.remove();
            connection.setAutoCommit(true);
            connection.close();
        }

    }
}
