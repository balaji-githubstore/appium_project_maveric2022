package com.maveric.macenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Demo4ActionScroll2NativeApp50 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ios");
		cap.setCapability("deviceName", "iPhone 12 Pro");
		cap.setCapability("platformVersion", "15.5");

		cap.setCapability("app", "/Users/balaji/Documents/Company/Maveric 2022/MobileAutomation/app/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");
		

		AppiumDriver driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// System.out.println(driver.getPageSource());

		// enter username - standard-user
		driver.findElement(AppiumBy.name("test-Username")).sendKeys("standard_user");

		// enter password - secret_sauce
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='test-Password']"))
				.sendKeys("secret_sauce");

		// click on login
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'LOGIN' AND name == 'test-LOGIN'")).click();

		// add the cart
		// *[@name='test-ADD TO CART' and @label='ADD TO CART']
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(AppiumBy.xpath("//*[@name='test-ADD TO CART']")).click();

		driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();

		Thread.sleep(5000);
		
		Dimension size= driver.manage().window().getSize();
		
		int width=size.width;
		int height=size.height;
		
		
		int x1=(int) (width*0.5);
		int y1=(int) (height*0.75);
		
		int x2=(int) (width*0.5);
		int y2=(int) (height*0.25);
		
		System.out.println(width);
		System.out.println(width);
		
		System.out.println(x1);
		System.out.println(y1);
		System.out.println(x2);
		System.out.println(y2);

		// presence
		int sizeC = driver.findElements(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).size();
		System.out.println(sizeC);

		// visibilty
		boolean visible = driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed();
		System.out.println(visible);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Actions action = new Actions(driver);

		//based of visibility - doing the scroll
		while (driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed() == false) 
		{		
			action.tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x1, y1))
			.tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
			.tick(new Pause(finger, Duration.ofMillis(600)))
			.tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x2, y2))
			.tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())).build().perform();
		}
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).click();

		Thread.sleep(5000);

		driver.quit();
		
		
//		while (driver.findElements(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).size()==1 && 
//				driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed() == false) 
//		{
//			action.press(PointOption.point(364, 503)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
//					.moveTo(PointOption.point(363, 414)).release().perform();
//		}
		

	}

}
