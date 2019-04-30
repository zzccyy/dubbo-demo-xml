package com.ciitc.provider.service.impl;

import com.ciitc.api.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Service一定要使用apache.dubbo的注解，alibaba和sprig的都不要用
 * 服务提供类
 * @author zhangchongying-JSB
 */
@Service
public class DemoServiceImpl implements DemoService {

    @PostConstruct
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-provider.xml"});
        context.start();
    }

    @Override
    public String sayHello(String name) {
        System.out.println("****** demoprovider被访问 ******");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
