package com.property.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.property.service.LoanServiceImp;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext cxt=new FileSystemXmlApplicationContext("src/main/java/com/property/cnfg/applicationContext.xml");
		LoanServiceImp bean = cxt.getBean("service",LoanServiceImp.class);
		//call b.method
		float calclAmt = bean.calclAmt(1009, "raja", 60000, 2, 20);
		System.out.println("intr amount"+calclAmt);
	}//main

}//class
