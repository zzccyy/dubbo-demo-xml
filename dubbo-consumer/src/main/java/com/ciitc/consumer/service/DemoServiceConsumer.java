package com.ciitc.consumer.service;

import com.ciitc.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoServiceConsumer {

    private static DemoService demoService = null;

    @PostConstruct
    public void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        // get remote service proxy
        demoService = (DemoService) context.getBean("demoService");
    }

    public String sayHello(String name) {
        return demoService.sayHello("world");
    }

}
