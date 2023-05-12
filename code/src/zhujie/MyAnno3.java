package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author: qjc
 * @Date: 2023/5/12 14:38
 * @Description: TODO
 **/

@Target(value = {ElementType.TYPE}) // 限制注解的使用范围
public @interface MyAnno3 {
}
