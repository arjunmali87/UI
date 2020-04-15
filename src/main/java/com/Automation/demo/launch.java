
package com.Automation.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class launch {
	

    public static WebDriver driver;

@BeforeTest
    public void createDriver()
    {
	DesiredCapabilities dr = null;
	dr = DesiredCapabilities.chrome();
	dr.setBrowserName("chrome");
	dr.setPlatform(Platform.WINDOWS);
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
//        driver = new ChromeDriver();
        
        try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.64:8090/wd/hub"), dr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

@Test
    public void case1()
    {
           
        driver.get("http://www.google.com");
        
        System.out.println("Url of case 1 : " + driver.getTitle());
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

        // Get attribute of current active element
        String attr = driver.switchTo().activeElement().getAttribute("title");
        System.out.println("after switch + " +attr);
        
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

@AfterTest
	public void quit()
	{
		driver.quit();
	}
    
}


