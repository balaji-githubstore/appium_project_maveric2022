package com.maveric.appiumserver;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

//appium server start and stop through code 

public class Demo1AppiumServerStart {

	public static void main(String[] args) {
		//before suite
		AppiumServiceBuilder builder=new AppiumServiceBuilder()
				.usingAnyFreePort()
				.withLogFile(new File("appium_log.log"))
				.withArgument(GeneralServerFlag.RELAXED_SECURITY)
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
		
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		service.start();
		
		System.out.println("-----------------------------------");
		System.out.println(service.getUrl());
		System.out.println(service.isRunning());
		System.out.println("-----------------------------------");
		//declare desired cap
		//connect khan academy app 
		//can do automation
		
		

//should always		
		service.stop();
		
		//will start at 12:05 AM IST
		
		
		
		

	}

}
