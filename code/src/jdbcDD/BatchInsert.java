package jdbcDD;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * @Author: qjc
 * @Date: 2023/5/8 19:54
 * @Description: 批量插入
 **/
public class BatchInsert {
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?rewriteBatchedStatements=true";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();

    }

    public static int getRandomInteger() {
        Random random = new Random();
        return random.nextInt(60);
    }

    @Test
    public  void testBatchInsert() throws ClassNotFoundException, SQLException {

        // 1. 注册驱动
        Class.forName(driverName);

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 编写sql,动态值用?代替
        String sql = "insert into User(username,age) values (?,?)";

        // 4. preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();

        // 5. 占位符赋值
        for (int i = 0;i<10000;i++){
            preparedStatement.setString(1, getRandomString(7));
            preparedStatement.setInt(2,getRandomInteger());

            preparedStatement.addBatch();


        }

        int[] ints = preparedStatement.executeBatch();


        long end = System.currentTimeMillis();

        System.out.println(end-start);
        System.out.println(ints.length);




        // 6. 发送SQL





        // 7. 输出
//        System.out.println("res:" + rows);
        // 8. 关闭

        preparedStatement.close();
        connection.close();


    }
}
