package org.example.springboot.demo.mycoolapp.rest;

import org.example.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    private Coach myCoach;

    @Autowired
    public FunRestController(@Qualifier("aquaticTrainer") Coach myCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;

    }

    @Value("${player.name}")
    private String playerName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "today is your lucky day";
    }
}
