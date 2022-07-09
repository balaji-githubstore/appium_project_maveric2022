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

public class Demo5ScrollMobileCommand {

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
		
		//scroll and bring the Art of Asia in viewport
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("strategy", "-android uiautomator");
		map.put("selector", "UiSelector().text(\"Art of Asia\")");
		
		//scroll and bring the Art of Asia in viewport
		driver.executeScript("mobile: scroll", map);
		
		//["mobile: scroll",[{"strategy":"-android uiautomator","selector":"UiSelector().text(\"Art of Asia\")"}]
		//click on Art of Asia
		driver.findElement(AppiumBy.xpath("//*[@text='Art of Asia']")).click();
		
		//scroll to South Asia
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("strategy", "-android uiautomator");
		map1.put("selector", "UiSelector().textContains(\"South Asi\")");
		
		driver.executeScript("mobile: scroll", map1);
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"South Asi\")")).click();
		
		
		//scroll and click on Three Hindu gods
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("strategy", "-android uiautomator");
		map3.put("selector", "UiSelector().textContains(\"Three Hindu\")");
		
		driver.executeScript("mobile: scroll", map3);
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Three Hindu\")")).click();
		
		String info=driver.executeScript("mobile: deviceInfo").toString();
		System.out.println(info);
		
		String binfo=driver.executeScript("mobile: batteryInfo").toString();
		System.out.println(binfo);
	}

}
