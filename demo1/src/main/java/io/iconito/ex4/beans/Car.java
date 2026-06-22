package io.iconito.ex4.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private String name;
    private Engine engine;

    @Autowired
    public Car(Engine engine){
        this.engine = engine;
        System.out.println("Car been created");
    }
    public Engine getEngine(){ return engine; }
    public void setEngine(Engine engine){ this.engine = engine; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    @PostConstruct
    public void initialize(){ this.name = "Kia"; }
    @Override
    public String toString(){ return "Car(" + "name='" + name + '\'' + '}'; }
}
