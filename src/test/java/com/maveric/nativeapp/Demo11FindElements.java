package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//scroll using TouchActions class - appium - java-client - 8.1.1
//scroll until art of asia present

public class Demo11FindElements {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app",
				"C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> elements= driver.findElements(AppiumBy.xpath("//*[@text='Dismiss']"));
		
		System.out.println(elements.size());

	}
}






