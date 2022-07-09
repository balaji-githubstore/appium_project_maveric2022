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

public class Demo16adbcommands {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");

		// cap.setCapability("noReset", true);

		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enable bluetooth
		driver.executeScript("mobile: shell",
				ImmutableMap.of("command", "am start -a android.bluetooth.adapter.action.REQUEST_ENABLE"));

		driver.findElement(AppiumBy.xpath("//*[@text='Allow']")).click();
		

		// disable bluetooth
		driver.executeScript("mobile: shell",
				ImmutableMap.of("command", "am start -a android.bluetooth.adapter.action.REQUEST_DISABLE"));

		driver.findElement(AppiumBy.xpath("//*[@text='Allow']")).click();
	}

}
