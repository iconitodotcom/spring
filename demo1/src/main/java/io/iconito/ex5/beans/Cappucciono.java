package io.iconito.ex5.beans;

import org.springframework.stereotype.Component;

@Component("cappuccino")
public class Cappucciono implements Coffee {

    @Override
    public String makeCoffe() {
        return "Cappuccino Coffe";
    }
}
