package org.javalord.beandefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

    static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.javalord.beandefinition");
        applicationContext.getBean(RestaurantService.class).makeOrder("pizza");

//        BeanDefinition bd = applicationContext.getBeanDefinition("restaurantService");
//        System.out.println(bd);
//        System.out.println(bd.getClass());

        var myBd = new GenericBeanDefinition();
        myBd.setBeanClass(MyClass.class);
        myBd.setInitMethodName("init");
        myBd.setDestroyMethodName("destroy");
        myBd.setPropertyValues(myBd.getPropertyValues().add("prop", "myValue"));
        myBd.setScope(BeanDefinition.SCOPE_PROTOTYPE);

        applicationContext.registerBeanDefinition("myClass", myBd);
        applicationContext.getBean(MyClass.class).myMethod();
        applicationContext.getBean(MyClass.class).myMethod();

        applicationContext.close();
    }

    @Bean
    public RestaurantService restaurantService(Cook cook) {
        return new RestaurantService(cook);
    }

    static class MyClass {

        private String prop;

        public MyClass() {
            System.out.println("My prop in constructor: " + prop);
        }

        void myMethod() {
            System.out.println("myMethod()");
            System.out.println("hash: " + this.hashCode());
        }

        void init() {
            System.out.println("init()");
            System.out.println("My prop in init: " + prop);
        }

        void destroy() {
            System.out.println("destroy()");
        }

        public void setProp(String prop) {
            this.prop = prop;
        }
    }
}
