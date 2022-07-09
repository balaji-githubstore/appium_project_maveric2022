package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//scroll using TouchActions class - appium - java-client - 8.1.1
//scroll until art of asia present

public class Demo10ScrollUsingActions2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app",
				"C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(AppiumBy.xpath("//*[@text='Dismiss']")).click();

		driver.findElement(AppiumBy.id("org.khanacademy.android:id/tab_bar_button_search")).click();

		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();

		Thread.sleep(5000);

		// scroll using actions
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Actions action = new Actions(driver);

		// scroll until art of asia present in the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		while (driver.findElements(AppiumBy.xpath("//*[@text='Art of Asia']")).size() == 0) 
		{
			action.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 971, 1276))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 982, 1045))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// click on Art of Asia
		//element should be present and visible 
		driver.findElement(AppiumBy.xpath("//*[@text='Art of Asia']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		while (driver.findElements(AppiumBy.xpath("//*[contains(@text,'South As')]")).size() == 0) 
		{
			action.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 971, 1276))
					.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
					.tick(new Pause(finger, Duration.ofMillis(600)))
					.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 982, 1045))
					.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// click on Art of Asia
		driver.findElement(AppiumBy.xpath("//*[contains(@text,'South As')]")).click();

	}
}
