package org.javalord.beanscope;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SlowCook implements Cook {
    @Override
    public void cook() {
        System.out.println("Very slow cook!");
        System.out.println("hash code: " + this.hashCode());
    }
}
