package io.iconito.ex3.config;

import io.iconito.ex3.beans.Vehicle;
import org.springframework.context.annotation.*;

/*
* Spring @Configuration annotation is part of the spring core framework.
* Sprint Configuration annotation indicates that the class has @Bean definition
* methods. So spring container can process the c lass and generate Spring Beans
* to be used in the application.
* */

@Configuration
@ComponentScan(basePackages = {"io.iconito.ex3.beans"})
public class ProjectConfig {

}
