package io.iconito.ex1;

import io.iconito.ex1.beans.Vehicle;
import io.iconito.ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean("vehicle1", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        var vehicle = (Vehicle) context.getBean("vehicle2");
        System.out.println("Vehicle name from Spring context is: " + vehicle.getName());

    }
}
