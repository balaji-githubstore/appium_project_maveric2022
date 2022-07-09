package com.maveric.macenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Demo1WebAppSafari {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformVersion", "15.5");
		
//		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("browserName", "safari");
		

		AppiumDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://facebook.com/");
		
		driver.findElement(AppiumBy.xpath("//input[@id='m_login_email']")).sendKeys("bala1233454@gmail.com");
		
//		driver.findElement(AppiumBy.xpath("//input[@id='m_login_password']")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("#m_login_password")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("[value='Log In']")).click();
		
	}
}
