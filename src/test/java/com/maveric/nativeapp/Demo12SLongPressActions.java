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

public class Demo12SLongPressActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Point p= driver.findElement(AppiumBy.xpath("//*[@text='Clock']")).getLocation();
		
		System.out.println(p.x);
		System.out.println(p.y);
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Actions action = new Actions(driver);
		
		action.
		tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), p.x, p.y))
		.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
		
		
		.tick(new Pause(finger, Duration.ofMillis(3000)))
		
		.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
		
		.build().perform();
		
		//App info
		driver.findElement(AppiumBy.xpath("//*[@text='App info']")).click();
	}
}






