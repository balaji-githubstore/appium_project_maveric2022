package com.maveric.macenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class Demo3IosSimulatorSauceApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformVersion", "15.5");

		cap.setCapability("app", "/Users/balaji/Documents/Company/Maveric 2022/MobileAutomation/app/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");
		

		AppiumDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//System.out.println(driver.getPageSource());
		
		//enter username - standard-user
		driver.findElement(AppiumBy.name("test-Username")).sendKeys("standard_user");
		
		//enter password - secret_sauce
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='test-Password']")).sendKeys("secret_sauce");
		
		//click on login
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'LOGIN' AND name == 'test-LOGIN'")).click();
		
		// add the cart
		//*[@name='test-ADD TO CART' and @label='ADD TO CART']
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();
		
		//scroll and click on checkout 
		//*[@name='test-CHECKOUT']
		
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("direction", "down");
		map.put("predicateString", "name == 'test-CHECKOUT'");
		
		driver.executeScript("mobile: scroll", map);
		
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).click();
		
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}

}
