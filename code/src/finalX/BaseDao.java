package finalX;

import DaoUtil.JdbcUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qjc
 * @Date: 2023/5/9 20:15
 * @Description: TODO
 **/
public abstract class BaseDao {

    /**
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql,Object... params) throws SQLException {

        Connection connection = JdbcUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 1; i <= params.length; i++) {
            preparedStatement.setObject(i,params[i-1]);
        }
        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();

        if (connection.getAutoCommit()){
            // 没有开启事务
            JdbcUtils.freeConnection();

        }

        return rows;

    }

    /**
     *
     * @param clazz 实体类
     * @param sql 查询语句，带？的
     * @param params 占位符的值，和sql对应
     * @param <T> 结果的范型
     * @return
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public <T>  List<T> executeQuery(Class<T> clazz,String sql,Object... params) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        if (params != null && params.length!=0){
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i,params[i-1]);
            }
        }

        ResultSet rs = preparedStatement.executeQuery();

        List<T> list = new ArrayList<>();

        ResultSetMetaData metaData = rs.getMetaData();

        int columnCount = metaData.getColumnCount();

        while (rs.next()){

            T t = clazz.newInstance(); //构造方法
            for (int i = 0; i < columnCount; i++) {
                Object value = rs.getObject(i);

                String propertyName = metaData.getColumnLabel(i); // 获取列名

                Field field = clazz.getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(t,value);

            }
            list.add(t);
        }
        //
        rs.close();
        preparedStatement.close();
        if (connection.getAutoCommit()){
            JdbcUtils.freeConnection();
        }

        return list;
    }
}
