package com.maveric.appiumserver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

//appium server start and stop through code 

public class Demo2AppiumServerStart {

	public static void main(String[] args) throws MalformedURLException {
		
		AppiumServiceBuilder builder=new AppiumServiceBuilder()
				.usingAnyFreePort()
				.withLogFile(new File("appium_log1.log"))
				.withArgument(GeneralServerFlag.RELAXED_SECURITY)
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
		
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		//appium service (npm) starts 
		service.start();
		
		System.out.println("-----------------------------------");
		System.out.println(service.getUrl());
		System.out.println(service.isRunning());
		System.out.println("-----------------------------------");


		//automation script 
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(service,cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Enter an e-mail address or username']")).sendKeys("bala");
		
		
		driver.quit();

//should always		
		service.stop();
		
		
		
		
		
		

	}

}
