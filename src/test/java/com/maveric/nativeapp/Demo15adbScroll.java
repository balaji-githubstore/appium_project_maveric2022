package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo15adbScroll {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		//cap.setCapability("noReset", true);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//*[@text='Dismiss']")).click();

		driver.findElement(AppiumBy.id("org.khanacademy.android:id/tab_bar_button_search")).click();

		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[@text='Big History Project']")));
		
        //scroll using adb
      
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		while (driver.findElements(AppiumBy.xpath("//*[@text='Art of Asia']")).size() == 0) 
		{
			driver.executeScript("mobile: shell", ImmutableMap.of("command","input touchscreen swipe 971 1276 982 1045"));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// click on Art of Asia
		driver.findElement(AppiumBy.xpath("//*[@text='Art of Asia']")).click();
		
		
	}

}
