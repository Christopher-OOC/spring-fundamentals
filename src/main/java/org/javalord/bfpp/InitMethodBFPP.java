package org.javalord.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitMethodBFPP implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(bdName -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(bdName);

            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                System.out.println("beanClassName is null");
                return;
            }

            if (!beanClassName.contains("org.javalord.bfpp")) {
                System.out.println(beanClassName + " not from our package");
                return;
            }

            try {
                Class<?> aClass = Class.forName(beanClassName);
                boolean annotationPresent = aClass.isAnnotationPresent(InitMethod.class);

                if (annotationPresent) {
                    InitMethod annotation = aClass.getAnnotation(InitMethod.class);
                    String value = annotation.value();
                    beanDefinition.setInitMethodName(value);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
