package org.javalord.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class SlowCook implements Cook, InitializingBean, DisposableBean {
    @Override
    public void cook() {
        System.out.println("Very slow cook!");
//        System.out.println("hash code: " + this.hashCode());
    }

    @PostConstruct
    public void init1() {
        System.out.println(this.getClass().getSimpleName() + ": called with @PostConstruct");
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
}
