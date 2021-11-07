package org.tei.ssmfileud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SsmFileudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmFileudApplication.class, args);
    }
}
