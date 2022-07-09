package com.maveric.nativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo9OpenApp {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bala");
		cap.setCapability("appPackage", "org.khanacademy.android");
		cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
		//cap.setCapability("noReset", true);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
//		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")));
		
		
		//click when dismiss avaialble otherwise skip
//		try
//		{
//			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
//		}
//		catch (Exception e) {
//			
//		}
		
		//click when dismiss avaialble otherwise skip. // checking element present or not 
		if(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size()>0)
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		}
		
//		//it will check only for visible. will not work when element not present 
//		if(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).isDisplayed())
//		{
//			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
//		}
		
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Enter an e-mail address or username']")).sendKeys("bala");
		driver.findElement(AppiumBy.xpath("//*[@content-desc='Password']")).sendKeys("welcome123");
		
		driver.findElement(AppiumBy.xpath("(//*[@text='Sign in'])[2]")).click();
		
		String actualError=driver.findElement(AppiumBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);	
		
		driver.quit();
		

	}

}
