package jdbcDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author: qjc
 * @Date: 2023/5/8 16:58
 * @Description: TODO
 **/
public class jdbcDemo {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";


    public static void main(String[] args) throws Exception {


        // 1. 注册驱动

        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);

        // 2. 获取连接
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);

        Connection connection = DriverManager.getConnection(URL, properties);


        /*
         * preparedstatement
         *
         * 3. 编写SQL语句。
         * 4. 创建预编译statement 并设置SQL。
         * 5. 单独的占位符进行赋值。
         * */
//        3. 编写SQL语句.
        String sql = "select * from User where username = ? and age = ?;";
//        4. 创建预编译statement 并设置SQL
        PreparedStatement paredStatement = connection.prepareStatement(sql);
//        5. 单独的占位符进行赋值.
        paredStatement.setString(1, "dageda");
        paredStatement.setString(2, "18");

        ResultSet resultSet = paredStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString("username")+" 年龄："+resultSet.getInt("age"));
        }


        // 6. 关闭资源
        resultSet.close();
        paredStatement.close();
        connection.close();


    }
}
