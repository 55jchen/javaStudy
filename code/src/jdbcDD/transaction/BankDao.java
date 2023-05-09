package jdbcDD.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: qjc
 * @Date: 2023/5/9 10:04
 * @Description: TODO
 **/
public class BankDao {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * 加钱
     *
     * @param account 加钱账号
     * @param money   添加金额
     */
    public void add(String account, int money,Connection connection) throws Exception {

        // 3. SQL
        String sql = "update t_bank set money = money + ? where account = ? ;";

        // 4. 创建statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);



        // 5. 赋值
        preparedStatement.setInt(1, money);

        preparedStatement.setString(2, account);


        // 6. 执行

        preparedStatement.executeUpdate();

        // 7. close

        preparedStatement.close();

    }

    /**
     * 扣钱
     *
     * @param account 扣钱账号
     * @param money   扣钱金额
     */
    public void sub(String account, int money,Connection connection) throws Exception {



        // 3. SQL
        String sql = "update t_bank set money = money - ? where account = ?;";

        // 4. 创建statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 5. 赋值

        preparedStatement.setInt(1, money);
        preparedStatement.setString(2, account);

        // 6. 执行

        int i = preparedStatement.executeUpdate();

        // 7. close

        preparedStatement.close();

    }
}
