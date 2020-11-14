package com.ithillel.config;

import com.ithillel.service.*;
import org.springframework.aop.scope.ScopedProxyFactoryBean;
import org.springframework.context.annotation.*;


public class AppConfig {/*

    @Bean(name = "storage")
    public Storage getStorage() {
        System.out.println("call getStorage() method");
        return new HashMapStorage();
    }

    @Bean(name = "textProcessor")
    public TextProcessor getTextProcessor() {
        return new InMemoryTextProcessor(getStorage());
    }

    @Bean(name = "fileTextProcessor")
    public TextProcessor getFileTextProcessor() {
        return new FileTextProcessor(getStorage());
    }*/

}
