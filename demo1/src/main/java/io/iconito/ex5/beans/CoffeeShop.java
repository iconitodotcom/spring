package io.iconito.ex5.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    private final Coffee coffee;

    @Autowired
    public CoffeeShop(@Qualifier("latte") Coffee coffee ){
        this.coffee = coffee;
    }
    public Coffee getCoffee(){ return coffee; }
}
