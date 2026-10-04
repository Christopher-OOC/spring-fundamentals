package org.javalord.bpp;

import org.jspecify.annotations.Nullable;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CriticalAnnotationBpp implements BeanPostProcessor {

    Map<String, Map<String, Long>> beanMap = new HashMap<>();

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Map<String, Long> map = ReflectionUtils.getMethods(bean.getClass(), e -> e.isAnnotationPresent(Critical.class)).stream()
                .collect(Collectors.toMap(Method::getName, e -> e.getAnnotation(Critical.class).maxTime()));

        if (map.isEmpty()) {
            return bean;
        }
        else {
            beanMap.put(beanName, map);
        }

        return bean;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!beanMap.containsKey(beanName)) {


        }
    }
}
