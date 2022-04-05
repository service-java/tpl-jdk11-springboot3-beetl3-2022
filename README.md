# README

- http://localhost:8080/api/user/listByAge?age=22
- http://localhost:8080/api/user/listByName?name=user
- http://localhost:8080/api/user/saveBatchUser

# BeetlSQL3 与 Mybatis @diff

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1649107127982-fjGDFcMKFT36.png)

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1649101233883-ShAXerhxeK28.png)

mybatis jdk17 @todo

# VSCode插件

- highlight-string-code

# 常见问题 @faq

- Flyway不支持mysql版本
  - https://blog.csdn.net/Beijing_L/article/details/122730110

```
降到v7.15.0
```

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1649187537556-ACWy3Rpyt5yH.png)

- Flyway - Unable to calculate checksum
  - https://blog.csdn.net/kida_yuan/article/details/113930069

```
sql文件要utf8编码
```

- jdk文本块功能很废, 没办法原生支持 ${} 填充变量值 @fix

```
当做函数的变量一起传入

===
但调用时会显得麻烦
最好再写一层xxxDao
```

![](https://luo0412.oss-cn-hangzhou.aliyuncs.com/1649148500966-hQFGZXRi4fj3.png)

- controller返回结果中文乱码
  - https://www.cnblogs.com/mzc1997/p/10260024.html
