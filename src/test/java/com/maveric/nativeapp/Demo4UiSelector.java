package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo4UiSelector {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		
		//content-desc
		driver.findElement(AppiumBy.accessibilityId("Settings")).click();
		
		//find using resource-id 
		//driver.findElement(AppiumBy.id("")).click();
		
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\")")).click();

		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"address\")")).sendKeys("bala");
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().descriptionContains(\"Pass\")")).sendKeys("hello123");
		
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\").index(0)")).click();
		

		
		String actualError=driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"issue\")")).getText();
		System.out.println(actualError);
		
		driver.quit();
	}

}
