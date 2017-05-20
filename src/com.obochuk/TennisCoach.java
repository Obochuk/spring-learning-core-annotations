package com.obochuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton" /*"prototype"*/)
public class TennisCoach implements Coach {
    // field injection
    @Autowired
    @Qualifier("randomFortuneServiceWithProperties")
    private FortuneService fortuneService;

    // define my init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach - inside init method");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach - inside destroy method");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    /*
    // default constructor
    public TennisCoach() {
        System.out.println(">> In constructor");
    }
    */

    /*
    // method injection
    @Autowired
    public void someMethod(FortuneService fortuneService){
        System.out.println(">> Inside someMethod");
        this.fortuneService = fortuneService;
    }
    */

    /*
    //setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Setting the fortuneService");
        this.fortuneService = fortuneService;
    }
    */

    /*
    // constructor injection
    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */
}
