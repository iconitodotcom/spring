package io.iconito.ex1.config;

import io.iconito.ex1.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Spring @Configuration annotation is part of the spring core framework.
* Sprint Configuration annotation indicates that the class has @Bean definition
* methods. So spring container can process the c lass and generate Spring Beans
* to be used in the application.
* */

@Configuration
public class ProjectConfig {

    /*
    * @Bean annotation, which lets Spring know it needs to call
    * this metho when it initializes its context and adds the returned
    * value to the context.
    * */
    @Bean
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Bean
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
    @Bean
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Combi");
        return veh;
    }

}
