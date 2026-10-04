package org.javalord.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class RestaurantService implements IRestaurantService, InitializingBean, DisposableBean, ApplicationContextAware {

    @Autowired
    SlowCook slowCook;

    @Value("my restaurant")
    private String name;

    public RestaurantService() {
    }

    public void makeOrder(String order) {
        System.out.println("Got order " + order);

        slowCook.cook();
    }

    @PostConstruct
    public void init1() {
        System.out.println(this.getClass().getSimpleName() + ": init1() called with @PostConstruct");
        System.out.println("My restaurant name is " + name);
    }

    @PostConstruct
    public void init1_1() {
        System.out.println(this.getClass().getSimpleName() + ": init1_1() called with @PostConstruct");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println(this.getClass().getSimpleName() + ": called with @PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": called with afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + ": called with destroy()");
    }

    @PostConstruct
    public void init2() {
        System.out.println(this.getClass().getSimpleName() + ": called with @Bean");
    }

    @PreDestroy
    public void destroy2() {
        System.out.println(this.getClass().getSimpleName() + ": called with @Bean");
    }

    @Override
    public void init3() {
        System.out.println(this.getClass().getSimpleName() + ": interfaced called with @PostConstruct");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Aware implementation was called");
    }
}
