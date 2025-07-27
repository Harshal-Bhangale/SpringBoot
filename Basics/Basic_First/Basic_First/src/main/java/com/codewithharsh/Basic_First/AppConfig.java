package com.codewithharsh.Basic_First;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// - Java Based Configuration -
//@Configuration
//public class AppConfig {
//    @Bean
//    public Sim sim()
//    {
////        return new Jio();
//        return new Airtel();
//    }
//}


@Configuration
@ComponentScan(basePackages = "com.codewithharsh")
public class AppConfig{
}