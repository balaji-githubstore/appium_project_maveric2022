package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo9OpenApp3 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("appPackage", "com.application.zomato");
		cap.setCapability("appActivity", "com.application.zomato.activities.Splash");
		cap.setCapability("noReset", true);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.findElement(AppiumBy.xpath("//*[@text='Money']")).click();
		
	
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
