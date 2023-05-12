package com.qjc.boot;

import com.qjc.boot.boot.Pet;
import com.qjc.boot.boot.User;
import com.qjc.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: qjc
 * @Date: 2023/5/11 10:35
 * @Description: TODO
 **/

@SpringBootApplication
public class   MyApplication {

    public static void main(String[] args) {

        // 1. ioc容器

        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);

        // 2. 查看容器内的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 3.从容器获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("-----------------------");
        System.out.println(tom01.toString());
        System.out.println(tom02);

        MyConfig bean = run.getBean(MyConfig.class);

        // 4. proxyBeanMethods 组件单例模式
        User user = bean.user01();
        User user1 = bean.user01();

        System.out.println(user==user1);

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);

        System.out.println(user01.getPet()==tom);



    }

}
