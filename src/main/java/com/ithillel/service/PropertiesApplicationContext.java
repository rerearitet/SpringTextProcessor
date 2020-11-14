package com.ithillel.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesApplicationContext implements ApplicationContext {

    private static final String TEXT_PROCESSOR = "textProcessor";
    private Map<String, Object> beans = new HashMap<>();

    public PropertiesApplicationContext() {
        Properties applicationProperties = new Properties();
        try {
            applicationProperties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = applicationProperties.getProperty(TEXT_PROCESSOR);
        try {
            beans.put(TEXT_PROCESSOR, Class.forName(value).getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }

    public static void main(String[] args) {
        PropertiesApplicationContext p = new PropertiesApplicationContext();

    }
}
