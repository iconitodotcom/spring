package io.iconito.ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherProjectConfig {

    @Bean
    String hellowWorld(){ return "Hello World!"; };
    @Bean
    Integer luckyNumber(){ return 16; }

}
