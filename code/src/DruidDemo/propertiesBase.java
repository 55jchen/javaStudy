package DruidDemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author: qjc
 * @Date: 2023/5/9 16:03
 * @Description: 从配置文件，构建连接
 **/
public class propertiesBase {

    @Test
    public void testSoft() throws Exception {
        // 1. 读取properties配置文件
        Properties properties = new Properties();

        InputStream resourceAsStream = propertiesBase.class.getClassLoader().getResourceAsStream("DruidDemo/mysqlCon.properties");

        URL druidDemo = propertiesBase.class.getClassLoader().getResource("");
        System.out.println("xxxxx");
        System.out.println("re:"+druidDemo);



        properties.load(resourceAsStream);
        
        // 2. 创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功！");

        //3. crud


        //4. 回收
        connection.close();

    }

}
