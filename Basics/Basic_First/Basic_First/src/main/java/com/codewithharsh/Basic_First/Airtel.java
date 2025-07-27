package com.codewithharsh.Basic_First;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
@Component("airtelBean")
public class Airtel implements Sim {
    public void data()
    {
        System.out.println("Data Airtel");
    }

    public void calling()
    {
        System.out.println("calling Airtel");
    }
}
