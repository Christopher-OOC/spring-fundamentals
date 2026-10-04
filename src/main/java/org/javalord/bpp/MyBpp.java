package org.javalord.bpp;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class MyBpp implements BeanPostProcessor {

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (!beanName.equalsIgnoreCase("restaurantService")) {
            return bean;
        }

        boolean isDyProxy = true;
        Object proxyInstance = null;

        if (isDyProxy) {
            proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("[dy proxy] before method call");
                Object invoke = method.invoke(bean, args);
                System.out.println("[dy proxy] after method call");

                return invoke;
            });
        }
        else {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(RestaurantService.class);
            enhancer.setCallback((InvocationHandler)(proxy, method, args) -> {
                System.out.println("[cglib proxy] before method call");
                Object invoke = method.invoke(bean, args);
                System.out.println("[cglib proxy] after method call");

                return invoke;
            });

            proxyInstance = enhancer.create();
        }


        System.out.println("BPP Works...");
        return proxyInstance;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
