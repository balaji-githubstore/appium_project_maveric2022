package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo7Scroll {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.xpath("//*[@text='Dismiss']")).click();
		
		//click on search 
		driver.findElement(AppiumBy.id("org.khanacademy.android:id/tab_bar_button_search")).click();
		
		//click on Arts and hummanities
		
		driver.findElement(AppiumBy.xpath("//*[@text='Arts and humanities']")).click();
		
		//UiSelector().text(\"Art of Asia\")
		
		String visibleText = "Art of Asia";
		
		driver.findElement(AppiumBy.androidUIAutomator
		        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))"));
		
		String text= driver.findElement(AppiumBy.androidUIAutomator("")).getText();
	       System.out.println(text);
		
		//scroll and click using text 
        driver.findElement(AppiumBy.androidUIAutomator
        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))")).click();
	
       
        visibleText = "South Asia";
    	//scroll and click using text 
        driver.findElement(AppiumBy.androidUIAutomator
        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))")).click();
	
        
    	//scroll and click using content-desc 
        String visibledesc = "";
        driver.findElement(AppiumBy.androidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\"" + visibleText + "\").instance(0))")).click();
        	
	}

}
