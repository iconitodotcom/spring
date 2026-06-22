package io.iconito.ex5;

import io.iconito.ex5.beans.Coffee;
import io.iconito.ex5.beans.CoffeeShop;
import io.iconito.ex5.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var coffeeShop = context.getBean(CoffeeShop.class);
        Coffee coffee = coffeeShop.getCoffee();
        System.out.println(coffee.makeCoffe());
    }
}
