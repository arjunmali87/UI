
package com.Automation.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class launch {
	

    public static WebDriver driver;

@BeforeTest
    public void createDriver()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

@Test
    public void case1()
    {
        driver.get("https:\\www.google.com");

        driver.manage().window().maximize();;
        
        System.out.println("Url of case 1 : " + driver.getTitle());
    }

@AfterTest
	public void quit()
	{
		driver.quit();
	}
    
}


