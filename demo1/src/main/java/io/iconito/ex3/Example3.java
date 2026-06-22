package io.iconito.ex3;

import io.iconito.ex3.beans.Vehicle;
import io.iconito.ex3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var v1 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + v1.getName());
        v1.sayHello();
        context.close();

    }
}
