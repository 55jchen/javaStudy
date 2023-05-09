package DaoUtil;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: qjc
 * @Date: 2023/5/9 16:31
 * @Description: TODO
 **/
public class Crud {

    @Test
    public void testInsert() throws SQLException {
        Connection con = JdbcUtils.getConnection();

        String sql = "insert into User(username,age) values (?,?)";

        //
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setString(1,"dageda");
        preparedStatement.setInt(2,30);

        preparedStatement.close();

        JdbcUtils.freeConnection();




    }
}
