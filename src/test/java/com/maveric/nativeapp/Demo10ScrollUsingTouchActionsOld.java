package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
//scroll using TouchActions class - appium - java-client - less than 8 version 
public class Demo10ScrollUsingTouchActionsOld {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//*[@text='Dismiss']")).click();
		
		driver.findElement(AppiumBy.id("org.khanacademy.android:id/tab_bar_button_search")).click();
		

		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();

		Thread.sleep(5000);
		
		//scroll using actions 
		
		TouchAction action = new TouchAction(driver);

		action.press(PointOption.point(971, 1276))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
		.moveTo(PointOption.point(982, 1045))
		.release()
		.perform();
		
		
		action.press(PointOption.point(971, 1276))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
		.moveTo(PointOption.point(982, 1045))
		.release()
		.perform();
		
		action.press(PointOption.point(971, 1276))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
		.moveTo(PointOption.point(982, 1045))
		.release()
		.perform();
		
		action.tap(PointOption.point(600, 900)).perform();
		
		action.longPress(PointOption.point(600, 900)).perform();

	}
}
