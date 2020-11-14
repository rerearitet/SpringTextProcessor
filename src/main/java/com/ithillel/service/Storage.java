package com.ithillel.service;

import java.util.function.BiFunction;

public interface Storage {
    void compute(String key,BiFunction<String, Object, Object> remappingFunction);
    Object get(String key);
}
