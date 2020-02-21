package com.mrghz.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mrghz.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		// get the beans from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		System.out.println("\nMain Program: AroundDemoApp");

		boolean tripWire = true;
		String data = null;

		try {
			data = theFortuneService.getFortune(tripWire);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nThe fortune is: " + data);
		System.out.println("Finished");

		// close the context
		context.close();

	}

}
