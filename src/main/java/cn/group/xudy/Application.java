package cn.group.xudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Configuration：标注此文件为一个配置项
 * @EnableAutoConfiguration：使用自动配置
 * @ComponentScan：可扫描的
 * @SpringBootApplication 包含上面三个
 * Application：启动管理器
 * Created by sun on 2017-1-14.
 */

@SpringBootApplication
@ComponentScan(basePackages = "cn.group.xudy")
@MapperScan("cn.group.xudy")
public class Application implements CommandLineRunner {

    /* Servlet容器默认的Context路径是/
    DispatherServlet匹配的路径(servlet-mapping中的url-patterns)是*//*
    @ComponentScan路径被默认设置为SampleController的同名package，
    也就是该package下的所有@Controller，@Service, @Component, @Repository都会被实例化后并加入Spring Context中。*/
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }

    // springboot运行后此方法首先被调用
    // 实现CommandLineRunner抽象类中的run方法
    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目启动完成！");
    }
}

