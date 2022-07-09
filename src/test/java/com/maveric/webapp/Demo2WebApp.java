package com.maveric.webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo2WebApp {

	public static void main(String[] args) throws MalformedURLException  {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Users\\JiDi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.get("http://facebook.com/");
		
		driver.findElement(AppiumBy.xpath("//input[@id='m_login_email']")).sendKeys("bala1233454@gmail.com");
		
//		driver.findElement(AppiumBy.xpath("//input[@id='m_login_password']")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("#m_login_password")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("[value='Log In']")).click();
		
	}

}
