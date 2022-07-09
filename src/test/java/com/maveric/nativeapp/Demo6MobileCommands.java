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

public class Demo6MobileCommands {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("app", "C:\\Mine\\Company\\Maveric Appium\\appium_workspace\\MobileAutomation\\app\\khan-academy-7-3-2.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("max", 2);
		
		String sms=driver.executeScript("mobile: listSms",map3).toString();
		System.out.println(sms);
		
		String info=driver.executeScript("mobile: deviceInfo").toString();
		System.out.println(info);
		
		String binfo=driver.executeScript("mobile: batteryInfo").toString();
		System.out.println(binfo);
	}

}
