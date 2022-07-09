package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
//cloud device
public class Demo3SignUp3 {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@content-desc='Settings']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign up with email']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='First name']")).sendKeys("bala");
		driver.findElement(AppiumBy.xpath("//*[@text='Last name']")).sendKeys("dina");
		
		//02 Aug 1995
		//driver.findElement(AppiumBy.xpath("//*[@text='Birthday']")).sendKeys("August 2, 2000");
		driver.findElement(AppiumBy.xpath("//*[@text='Birthday']")).click();
		
		
		List<WebElement> elements=driver.findElements(AppiumBy.xpath("//*[@resource-id='android:id/numberpicker_input']"));
		
		elements.get(0).click();
		elements.get(0).clear();
		elements.get(0).sendKeys("02");
		
		elements.get(1).click();
		elements.get(1).clear();
		elements.get(1).sendKeys("Aug");
		
		
		elements.get(2).click();
		elements.get(2).clear();
		elements.get(2).sendKeys("1995");
		
		
		
		driver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();
		
		
		driver.findElement(AppiumBy.xpath("//*[@text='Email address']")).sendKeys("dina1234@gmail.com");
		driver.findElement(AppiumBy.xpath("//*[@text='Password']")).sendKeys("welcome123");
		//click on create
		
		// (//*[@text='Password']/following-sibling::*)[1]
		driver.quit();
		
		
	}

}
















