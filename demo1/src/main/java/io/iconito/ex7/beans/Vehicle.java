package io.iconito.ex7.beans;

public class Vehicle {

    private String name;
    private Engine engine;

    public Vehicle(Engine engine){
        this.engine = engine;
        System.out.println("Vehicle been created");
    }

    public Engine getEngine() { return engine; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }
}
