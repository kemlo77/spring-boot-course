package org.example.springboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "spend 30 minutes in batting practice";
    }
}
