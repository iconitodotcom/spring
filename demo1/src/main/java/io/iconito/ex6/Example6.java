package io.iconito.ex6;

import io.iconito.ex6.beans.MyService;
import io.iconito.ex6.beans.UserSession;
import io.iconito.ex6.config.ProjectScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Example6 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectScopeConfig.class);
        var myservice1 = context.getBean(MyService.class);
        var myservice2 = context.getBean(MyService.class);
        System.out.println(myservice1.hashCode());
        System.out.println(myservice2.hashCode());
        var user1 = context.getBean(UserSession.class);
        var user2 = context.getBean(UserSession.class);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.getSessionId());
        System.out.println(user2.getSessionId());
    }
}
