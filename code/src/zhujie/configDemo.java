package zhujie;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: qjc
 * @Date: 2023/5/12 17:19
 * @Description: TODO
 **/
@configAnno(className ="zhujie.Demo2",methodName = "show")
public class configDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 解析注解
        Class<configDemo> configDemoClass = configDemo.class;
        // 2. 获取注解对象
        configAnno annotation = configDemoClass.getAnnotation(configAnno.class);
        // 3.

        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);


    }
}
