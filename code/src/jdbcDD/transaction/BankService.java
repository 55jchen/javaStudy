package jdbcDD.transaction;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Author: qjc
 * @Date: 2023/5/9 10:06
 * @Description: 银行卡业务
 **/
public class BankService {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Test
    public void start() throws Exception {
        transfer("ergouzi","lvdandan",500);
    }


    /**
     * 转账
     * @param addAccount
     * @param subAccount
     * @param money
     */
    public void transfer(String addAccount, String subAccount, int money) throws Exception{

        // 1. 加载类
        BankDao bankDao = new BankDao();
        Class.forName(driverName);
        // 2. 获取连接
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);

        Connection connection = DriverManager.getConnection(URL, properties);

        try {
            // 开启事务
            // 关闭事务自动提交！！
            connection.setAutoCommit(false);

            // 执行数据库动作
            bankDao.add(addAccount,money,connection);
            System.out.println("-------------");
            bankDao.sub(subAccount,money,connection);

            connection.commit();

        }catch (Exception e){

            // 事务失败回滚
            connection.rollback();


            throw e;
        }finally {
            connection.close();
        }








    }
}
