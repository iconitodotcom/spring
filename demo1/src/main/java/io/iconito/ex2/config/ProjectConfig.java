package io.iconito.ex2.config;

import io.iconito.ex2.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
* Spring @Configuration annotation is part of the spring core framework.
* Sprint Configuration annotation indicates that the class has @Bean definition
* methods. So spring container can process the c lass and generate Spring Beans
* to be used in the application.
* */

@Configuration
@Import({AnotherProjectConfig.class})
public class ProjectConfig {

    /*
    * @Bean annotation, which lets Spring know it needs to call
    * this metho when it initializes its context and adds the returned
    * value to the context.
    * */
    @Bean(name = "vochoVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Primary
    @Bean(value = "toyotaVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
    @Bean({"combiVehicle", "theBestVehicle"})
    @Description("This is a Vehicle class bean")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Combi");
        return veh;
    }

}
