package com.maveric.webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo3WebApp {

	public static void main(String[] args) throws MalformedURLException  {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Components\\chromedriver.exe");
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deviceName", "Nexus 5");
				
		ChromeOptions options = new ChromeOptions();	
		options.setExperimentalOption("mobileEmulation", map);
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://facebook.com/");
		
		driver.findElement(AppiumBy.xpath("//input[@id='m_login_email']")).sendKeys("bala1233454@gmail.com");
		
//		driver.findElement(AppiumBy.xpath("//input[@id='m_login_password']")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("#m_login_password")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.cssSelector("[value='Log In']")).click();
		
	}

}
