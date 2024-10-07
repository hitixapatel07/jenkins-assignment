package com.assignment.my_jenkins_assignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World!");
        
      //WebDriver driver = new ChromeDriver();
      		ChromeOptions options = new ChromeOptions();
      		options.addArguments("--headless");
      		WebDriver driver = new ChromeDriver(options);
      		// 1. open url
      		// 1. open url
      		driver.get("http://52.15.183.252:8080/war-test-freestyle/");
      		
      		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
      	
      		
      		WebElement text1 = driver.findElement(By.xpath("/html/body/h1"));
      	       
              // Check if website access was successful
              
              if (text1.getText().contains("Congratulations!!! Welcome to the world of Automation")) {
              	System.out.println("Access successfull!");
              }else {
              	System.out.println("something went wrong can't access the page!");
              }
              
              
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

      		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

      		File destFile = new File("test-report.jpg");

      		FileUtils.copyFile(srcFile, destFile);
      		driver.quit();
    }
}
