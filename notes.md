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
