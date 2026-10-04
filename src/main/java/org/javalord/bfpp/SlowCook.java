package org.javalord.bfpp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SlowCook {

    public void cook() {
        System.out.println("Very slow cook!");
//        System.out.println("hash code: " + this.hashCode());
    }

}
