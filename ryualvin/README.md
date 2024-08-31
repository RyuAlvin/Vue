# 防止SpringBoot工程打包出现空包的现象

**空包：**

![image-20240831201610174](./assets/image-20240831201610174.png)

![image-20240831201730699](./assets/image-20240831201730699.png)

**在pom文件中添加构建配置，指定主程序入口，从主程序入口开始依次向下打包：**

```xml
    <build>
        <plugins>
            <!-- Package as an executable jar -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
<!--                    指定入口，从入口开始打包-->
                    <mainClass>org.yeahicode.YCZApplication</mainClass>
                    <!--打包成可执行文件-->
                    <executable>true</executable>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

![image-20240831202137764](./assets/image-20240831202137764.png)