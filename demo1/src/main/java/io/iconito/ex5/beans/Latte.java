package io.iconito.ex5.beans;

import org.springframework.stereotype.Component;

@Component("latte")
public class Latte implements Coffee{

    @Override
    public String makeCoffe() {
        return "Latte  coffee";
    }
}
