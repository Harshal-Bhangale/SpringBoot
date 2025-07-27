package com.codewithharsh.Basic_First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//@SpringBootApplication
//public class Mobile {
//
//	public static void main(String[] args) {

//		SpringApplication.run(BasicFirstApplication.class, args);
//
//		System.out.println("Hello World");
//
////		Sim sim = new Airtel();
//		Sim sim = new Jio();
//
//		sim.data();
//		sim.calling();

//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfi.class);
//
//		Sim sim = context.getBean("sim",Sim.class);
//		sim.calling();
//		sim.data();
//	}
//}


/* Java Based Configuration -
* Interface - Sim
* Implementation Class from Sim -
* 	1. Airtel
* 	2. Jio
* Configuration Class - AppConfig
* Main Class - Mobile*/


//@Component
//public class Mobile {
//	@Autowired
////	@Qualifier("jio")
//	@Qualifier("airtelBean")
//	private Sim sim;
//
//	public void useSim() {
//		sim.calling();
//		sim.data();
//	}
//	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Mobile mobile = context.getBean(Mobile.class);
//		mobile.useSim();
//	}
//}


import org.springframework.boot.CommandLineRunner;

@Component
public class Mobile implements CommandLineRunner {  // Implement the interface
	@Autowired
	@Qualifier("airtelBean")
	private Sim sim;

	@Override  // Override run() instead of main()
	public void run(String... args) {
		sim.calling();
		sim.data();
	}
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}