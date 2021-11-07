package org.tei.ssmfileud.controller;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tei.ssmfileud.entity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/index")
    public String index(){
        User user =new User();
        user.setId(null);
        System.out.println("validator => " + validator);
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        for (ConstraintViolation<User> violation : validate) {
            System.out.println("violation.getMessage() => " + violation.getMessage());
        }
        return "success";
    }

    private boolean check(@Validated User user){
        return true;
    }

}
