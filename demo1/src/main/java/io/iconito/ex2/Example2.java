package io.iconito.ex2;

import io.iconito.ex2.beans.Vehicle;
import io.iconito.ex2.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean("vochoVehicle", Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        var vehicle = (Vehicle) context.getBean("theBestVehicle");
        System.out.println("Vehicle name from Spring context is: " + vehicle.getName());

        var v1 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + v1.getName());

        var str = context.getBean(String.class);
        System.out.println("String value from Spring Context is: " + str);

    }
}
