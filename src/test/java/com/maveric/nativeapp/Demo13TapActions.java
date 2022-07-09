package com.maveric.nativeapp;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//scroll using TouchActions class - appium - java-client - 8.1.1

public class Demo13TapActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@content-desc='Settings']")).click();

		Point p= driver.findElement(AppiumBy.xpath("//*[@text='OFF']")).getLocation();
		
		System.out.println(p.x);
		System.out.println(p.y);
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Actions action = new Actions(driver);
		
		
		for(int i=1;i<=10;i++)
		{
			action.
			tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), p.x, p.y))
			.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
			.tick(new Pause(finger, Duration.ofMillis(600)))
			.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
			
			.build().perform();
		}
		
	}
}






