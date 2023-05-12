| 日期     | 内容     | 备注 |
| -------- | -------- | ---- |
| 23/05/04 | java集合 |      |
| 23/05/05 | jdbc||






### StringBuilder/StringBuffer

```
String 是不可变对象
StringBuffer: 线程安全
StringBuilder: 线程不安全

一般情况下速度：
StringBuilder > StringBuffer > String
```

### 注解

#### Retention
```
RetentionPolicy.SOURCE  不会保留到编译后的字节码文件中，用于在编译器中生成代码或为编译器提供额外的信息
RetentionPolicy.CLASS 保留在编译后的字节码文件中，但在运行时不可用。提供给 IDE 或其他工具使用的注解
RetentionPolicy.RUNTIME 保留在编译后的字节码文件中，并且在运行时也可用。实现框架、库或插件系统。
```


### 反射
```java
    String className = "xxx";
    String methodName = "xxxx";
    Class<?> cls = Class.forName(className);
    Object obj = cls.newInstance();
    Method method = cls.getMethod(methodName);
    method.invoke(obj);
```



