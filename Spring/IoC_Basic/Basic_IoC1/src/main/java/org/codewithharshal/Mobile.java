package org.codewithharshal;

//public class Mobile {
//    public static void main(String[] args) {
////        System.out.println("Hello, World!");
//
////        Sim sim = new Airtel();
//        Sim sim = new Jio();
//
//        sim.calling();
//        sim.data();
//    }
//}

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Mobile {
    public static void main(String[] args) {

        // Using ApplicationContext tom implement Spring IoC
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // Get the bean
        Sim sim = applicationContext.getBean("sim", Sim.class);

        // Calling the methods
        sim.calling();
        sim.data();
    }
}