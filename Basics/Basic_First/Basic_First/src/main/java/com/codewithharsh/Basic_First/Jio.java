package com.codewithharsh.Basic_First;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Jio implements  Sim {
    public void data()
    {
        System.out.println("Data Jio");
    }
    public  void calling()
    {
        System.out.println("Calling Jio");
    }
}
