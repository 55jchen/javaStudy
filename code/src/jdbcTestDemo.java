import org.junit.Test;

import java.sql.*;
import java.util.HashMap;

/**
 * @Author: qjc
 * @Date: 2023/5/8 17:29
 * @Description: TODO
 **/
public class jdbcTestDemo {
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName(driverName);

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 编写sql,动态值用?代替
        String sql = "insert into User(username,age) values(?,?);";

        // 4. preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. 占位符赋值
        preparedStatement.setString(1,"kangbazi");
        preparedStatement.setInt(2,32);
        // 6. 发送SQL

        int rows = preparedStatement.executeUpdate();

        if (rows>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

        // 7. 输出
        System.out.println("res:"+ rows);
        // 8. 关闭

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName(driverName);

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 编写sql,动态值用?代替
        String sql = "update User set age = ? where username=?";

        // 4. preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. 占位符赋值
        preparedStatement.setInt(1,35);
        preparedStatement.setString(2,"kangbazi");

        // 6. 发送SQL

        int rows = preparedStatement.executeUpdate();

        if (rows>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        // 7. 输出
        System.out.println("res:"+ rows);
        // 8. 关闭

        preparedStatement.close();
        connection.close();

    }

    @Test
    public void testDelete() throws ClassNotFoundException, SQLException {

        // 1. 注册驱动
        Class.forName(driverName);

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 编写sql,动态值用?代替
        String sql = "delete from User where age=? and username=?;";

        // 4. preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. 占位符赋值
        preparedStatement.setInt(1,35);
        preparedStatement.setString(2,"kangbazi");

        // 6. 发送SQL

        int rows = preparedStatement.executeUpdate();

        if (rows>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        // 7. 输出
        System.out.println("res:"+ rows);
        // 8. 关闭

        preparedStatement.close();
        connection.close();

    }


    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName(driverName);

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 编写sql,动态值用?代替
        String sql = "select username,age from User where username=? and age=?;";

        // 4. preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. 占位符赋值
        preparedStatement.setString(1,"dageda");
        preparedStatement.setInt(2,18);

        // 6. 发送SQL

        ResultSet resultSet = preparedStatement.executeQuery();


        // 7. 输出
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("username")+":"+resultSet.getInt("age"));
//        }

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            HashMap map = new HashMap();


        }



        // 8. 关闭
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
