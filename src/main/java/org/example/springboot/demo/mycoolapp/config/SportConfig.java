package org.example.springboot.demo.mycoolapp.config;

import org.example.springboot.demo.mycoolapp.common.Coach;
import org.example.springboot.demo.mycoolapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquaticTrainer")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
