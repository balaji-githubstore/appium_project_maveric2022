package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo2NativeApp {

	public static void main(String[] args) throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Enter an e-mail address or username']")).sendKeys("bala");
		driver.findElement(AppiumBy.xpath("//*[@content-desc='Password']")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.xpath("(//*[@text='Sign in'])[2]")).click();
		
		String actualError=driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);	
		
		driver.quit();
	}

}



