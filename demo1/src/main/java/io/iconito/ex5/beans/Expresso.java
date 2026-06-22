package io.iconito.ex5.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("expresso")
@Primary
public class Expresso implements Coffee {
    @Override
    public String makeCoffe() {
        return "Expresso Coffe";
    }
}
