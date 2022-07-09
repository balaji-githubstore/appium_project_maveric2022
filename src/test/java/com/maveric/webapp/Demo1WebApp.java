package com.maveric.webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo1WebApp {

	public static void main(String[] args) throws MalformedURLException  {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutable", "C:\\Users\\JiDi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.get("http://google.com/");
		
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String source= driver.getPageSource();
		System.out.println(source);
		
        driver.quit();
	}

}
