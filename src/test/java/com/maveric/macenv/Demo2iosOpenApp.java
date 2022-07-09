package com.maveric.macenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Demo2iosOpenApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformVersion", "15.5");

		cap.setCapability("bundleId", "com.apple.Health");
		

		AppiumDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		driver.findElement(AppiumBy.xpath("//*[@name='Edit']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='All']")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}
}
