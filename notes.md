# Course Notes
### author : julio conchas <conchasjimenez@gmail.com>
---

pom.xml add dependencies to tranfor project into Spring project 
to know what's the latest dependency version go to spring.io -> Projects -> Spring Framework

**Path:** demo/pom.xml

```
<dependencies>
    <dependency>
        <groupId>org.springframwrok</groupId>
        <artifactId>spring-context</artifactId>
        <version>latest version from spring.io</version>
    </dependency>
</dependencies>
```

after include dependencys sync maven dependencies 

**Path:** demo/src/main/java:   
- create package
- create main class -l 

---

## Maven Build Toold
- Command Maven commands
    - mvn clean : Remove old compiled files : 
    - mvn validate : Check if our project is correctly configured
    - mvn compile : compile our java source code
    - mvn test : Run all unit test
    - mvn pacakge : package the project into java (java arquives) or war ( web archives)
    - mvn verify : it wnsures the build
    - mvn install :
    - mvn deploy : uploads your project's JAR/WAR file to a remote Maven repository for sharing with other developers/projects
    - mvn site - use to generate a project documentation website for a Maven project - automatically
- complete flow:
    - validate -> compile -> test -> package -> verify -> install -> deploy

## Spring Core
- Key components of spring core
    - **IoC (Inversion of Control)** - Shifts control of object creation to the Spring container.
    - **DI (Dependency Injection)** - Manages dependencies automatically, reducing tight coupling.
    - **Beans** - Objects managed by the Spring IoC container
    - **IoC Container** - The core mechanism that creates, manages, and provides dependencies for beans
    - **Context** - Provides runtime configuration and manages the lifecycle of beans

# Bean creation
```
@Configuration
public class ProjectConfig{
    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
}
```

**Path:** /demo/src/main/java/io.iconito.beans 
- create Vehicle.java class
**Path:** /demo/src/main/java/io.iconito.config
- create  ProjectConfig.java class 
- create vehicle bean
- create hello bean 
**Path:** /demo/src/main/java/io.iconito/main.java
- call vehicle object 

---

### Section 2: Spring Beans Deep Dive - AutoWriting Scopes and More
#### Why Spring Gets Confused - NoUniqueBeanDefinitionExceptions Explained
- it will be thrown if define many Beas but of the same type 
```
@Configuration
public class ProjectConfig{
    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
        @Bean
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
        @Bean
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
}
```
- to fix that need to call getBean with the class name and type
```
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var veh = context.getBean("vehicle2",Vehicle.class);
    System.out.println("Vehicle name from Spring Context is: " + veh.getName());
```
- this abiguity can also be fixes by calling getBean only with the class name 
```
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var veh = context.getBean("vehicle2");
    System.out.println("Vehicle name from Spring Context is: " + veh.getName());
```

#### Naming Your Beans - Creating Custom Bean Names
```
@Configuration
public class ProjectConfig{
    @Bean(name="audiVehicle")
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
    @Bean(value="vochoVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Bean({"toyotaVehicle","myFavoriteVehicle"})
    @Description("This is a really awezome toyota bean")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
}
```
```
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var veh = context.getBean("audiVehicle",Vehicle.class);
    System.out.println("Vehicle name from Spring Context is: " + veh.getName());
```

```
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    var veh = context.getBean("myFavouriteVehicle");
    System.out.println("Vehicle name from Spring Context is: " + veh.getName());
```

#### @Primary - Choosing the 'Default' Bean
- by adding @Primary annotation that class will be called when ambiguiti in ProjectConfig
```
@Configuration
public class ProjectConfig{
    @Bean(name="audiVehicle")
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
    @Primary
    @Bean(value="vochoVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Bean({"toyotaVehicle","myFavoriteVehicle"})
    @Description("This is a really awezome toyota bean")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
}
```

#### Modular Config Made Easy with @Import
- I can create as many config classes as it's needed 

```
@Configuration
public class AnotherProjectConfig{
    @Bean(name="audiVehicle")
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
    @Primary
    @Bean(value="vochoVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Bean({"toyotaVehicle","myFavoriteVehicle"})
    @Description("This is a really awezome toyota bean")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
}
```
- AnnotationConfigApplicationContext support many config classes 
```
    var context = new AnnotationConfigApplicationContext(AnotherprojectConfig.class, ProjectConfig.class);
```
- A better way to call AnnotationConfigAplicationContext, is to add @Import annotation

```
@Configuration
@Import({AnnotherProjectConfig.class})
public class ProjectConfig{
    @Bean(name="audiVehicle")
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Tesla");
        return veh;
    }
    @Primary
    @Bean(value="vochoVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Vocho");
        return veh;
    }
    @Bean({"toyotaVehicle","myFavoriteVehicle"})
    @Description("This is a really awezome toyota bean")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }
}
```

#### Bean Creation the Easy Way - @Component
**None:** This option is better use for object that don't need to change during the application busines loging 

add @Componenet annotation do out class
```
@Component 
public class Vehicle
```
add @ComponentScan annotation and pass the package name where Spring has to scan for Beans
```
@Configuration
@ComponenetScan(basePackages={<package.name>})
public class ProjectConfig{

}
```
---

#### Bean Lifecycle Hooks - @PostConstruct & @PreDestroy

- Those classes using @Component most have initialize method 
- need to include Jakarta library to use Jakarta annotations , for that need to add new dependecie 
- to the pom.xml with jakarta dependecy that can be found in mvnrepository website
- @PostConstruct will be calle after object is created 

```
@Component
public class Vehicle {
    #PostConstruct
    public void initialize(){}
    .
    .
    .
}
```
- another option we have to initialize Beans that use @Componenet is by extend from InitializingBean
- then override afterPropertiesSet method
```
@Override
public void afterPropertiesSet() throws Exception {
    this.name = "Tesla" // for example
}
```
- there is also an option to execute code before object is destroy usually when application is shutdown 
- for that we need to use annotation @PreDestroy

```
@PreDestroy
public destroy(){
    System.out.println("This Bean is being Destroy...");
}
```
---
#### @Bean vs @Component - What'ts the Difference ?

---
#### Meet Spring's Stereotypes - @Component, @Service, @Repository, @Controller
Layers in a Backend Application
1. Controler / presentation Layer:
    - Recives request from the cliente ( e.g, frontend, mobile app, postman) 
    - Calls the Service layer from business logic.
    - Returns responses ( usually JSON or XML )
2. Service / Business logic layer:
    - Implements business rules validation, and transformations
    - Calls repositories to fetch 
3. Repository / Data Access Layer:
    - Handles data persistance ( CRUD operations)
    - Uses Spring Data JPA or JDBC to interact with databases
    - Performs queries using JPQL or native SQL

---
#### Method - Based Bean Wiring - Theory

---
#### method-Based Bean Wiring - Hands-On Demo
```
public class Vehicle{
    .
    .
    .
}

public Person(){
    .
    .
    .
}

public class ProjectConfig{
    @Bean
    Vehicle vehicle() {
        Vehicle veh = new vehicle();
    }
    @Bean
    Person person(Vehicle veh){  // <== creating relation of clases of Bean Wiring 
        Person p = new Person();
        p.setName("fulana");
        p.setVehicle(veh);
    }
}
```
---

```

```