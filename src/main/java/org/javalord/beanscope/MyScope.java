package org.javalord.beanscope;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyScope implements Scope {

    private Map<String, Map.Entry<LocalDateTime, Object>> beansMap = new ConcurrentHashMap<>();
    private Map<String, Runnable> destroyMaps = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        beansMap.computeIfAbsent(name, k -> new AbstractMap.SimpleEntry<>(LocalDateTime.now(), objectFactory.getObject()));

        return beansMap.computeIfPresent(name, (k, v) -> {
            LocalDateTime time = v.getKey();
            if (time.isBefore(LocalDateTime.now().minusSeconds(5))) {
                return new AbstractMap.SimpleEntry<>(LocalDateTime.now(), objectFactory.getObject());
            }

            return v;
        }).getValue();
    }

    @Override
    public @Nullable Object remove(String name) {
        destroyMaps.remove(name);
        return beansMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destroyMaps.put(name, callback);
    }

    @Override
    public @Nullable Object resolveContextualObject(String key) {
        return Scope.super.resolveContextualObject(key);
    }

    @Override
    public @Nullable String getConversationId() {
        return "myScope";
    }
}
