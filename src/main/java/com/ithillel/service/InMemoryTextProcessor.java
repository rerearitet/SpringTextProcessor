package com.ithillel.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class InMemoryTextProcessor implements TextProcessor, InitializingBean {


    public Storage storage;

    public InMemoryTextProcessor(Storage storage) {
        System.out.println("call InMemoryTextProcessor");
        this.storage = storage;
    }

    public void save(String key, final String text) {
        if (isEmpty(key)) throw new IllegalArgumentException("key must be a set");
        if (isEmpty(text)) return;
        storage.compute(key, (k, value) -> (value == null ? text : "\n" + text));
    }

    private boolean isEmpty(String key) {
        return Objects.isNull(key) || key.isEmpty();
    }

    public String getByKey(String key) {
        if (isEmpty(key)) throw new IllegalArgumentException("key must be a set");
        String text = (String) storage.get(key);
        if (text == null ) throw new IllegalStateException("key not found");
        return text;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
