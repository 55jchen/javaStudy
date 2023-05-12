package com.qjc.boot.config;

import com.qjc.boot.boot.Pet;
import com.qjc.boot.boot.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qjc
 * @Date: 2023/5/11 16:10
 * @Description: TODO
 **/

@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public User user01(){
        User zhangsan = new User("zhangsan", 19);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet();
    }
}
