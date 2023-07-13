package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ServletComponentScan
@SpringBootApplication
@EnableAsync
@Slf4j
//@MapperScan项目启动时会自动加载包路径下的Mapper接口，也可以在每个Mapper接口上增加@Mapper注解，但是如果接口过多，建议使用以下注解
//@MapperScan(basePackages = "com.example.springbootdemo.db.dao")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  六叶草启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "◇◇◇◆◆◆◆◇◇◇◇◇◇◇◇◆◆◆◇◆◆◆◇◇◇◇◇◇◆◆◆◆◆◇◇◇\n" +
                "◇◇◇◇◆◇◇◇◇◇◇◇◇◇◇◇◆◆◇◆◆◇◇◇◇◇◇◆◆◇◇◇◆◆◇◇\n" +
                "◇◇◇◇◆◇◇◇◇◇◇◇◇◇◇◇◆◆◆◆◆◇◇◇◇◇◇◆◆◇◇◇◆◇◇◇\n" +
                "◇◇◇◇◆◇◇◇◇◇◇◇◇◇◇◇◇◆◆◆◇◇◇◇◇◇◇◆◆◇◇◇◇◇◇◇\n" +
                "◇◇◇◇◆◇◇◇◆◆◇◇◇◇◇◇◇◇◆◇◇◇◇◇◇◇◇◆◆◇◇◇◇◇◇◇\n" +
                "◇◇◇◇◆◇◇◇◆◆◇◇◇◇◇◇◇◇◆◇◇◇◇◇◇◇◇◆◆◆◇◇◆◆◇◇\n" +
                "◇◇◇◆◆◆◆◆◆◇◇◇◇◇◇◇◆◆◆◆◇◇◇◇◇◇◇◇◆◆◆◆◆◇◇◇");
    }

}
