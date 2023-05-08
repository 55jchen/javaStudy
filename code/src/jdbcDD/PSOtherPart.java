package jdbcDD;

import java.sql.*;
import java.util.Properties;
import java.util.Random;

/**
 * @Author: qjc
 * @Date: 2023/5/8 19:02
 * @Description: TODO
 **/
public class PSOtherPart {
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();

        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();

    }

    public static int getRandomInteger(){
        Random random = new Random();
        return random.nextInt(60);
    }

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
        String sql = "insert into User(username,age) values (?,?);";


//        4. 创建预编译statement 并设置SQL
        PreparedStatement paredStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        5. 单独的占位符进行赋值.
        paredStatement.setString(1, getRandomString(8));
        paredStatement.setInt(2, getRandomInteger());

        int i = paredStatement.executeUpdate();

        if (i>0){
            System.out.println("插入成功");
            ResultSet generatedKeys = paredStatement.getGeneratedKeys();
            generatedKeys.next();

            int anInt = generatedKeys.getInt(1);

            System.out.println(anInt);
            System.out.println("--------");

        }else {
            System.out.println("插入失败");
        }


        // 6. 关闭资源
//        resultSet.close();
        paredStatement.close();
        connection.close();


    }


}
