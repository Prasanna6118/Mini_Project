package com.MiniProject;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

public class Mini_Project {


 
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\samundeewari D\\eclipse-workspace\\Redbus\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prasanna18h003@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Prasanna12356789");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		driver.findElement(By.xpath("(//a[text()='Dresses'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='block_content']//a[@title='Browse our different dresses to choose the perfect dress for an unforgettable evening!'][normalize-space()='Evening Dresses']"));
		driver.findElement(By.xpath("(//a[@class='img'])[2]")).click();
		Actions act=new Actions(driver);
        WebElement quickview = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
        act.moveToElement(quickview).perform();
        driver.findElement(By.xpath("//a[@class='quick-view']")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(frame1);
         driver.findElement(By.xpath("//a[@name='Pink']")).click();
         WebElement quantity = driver.findElement(By.xpath("//i[@class='icon-plus']"));
         for(int i=0;i<9;i++) {
 			quantity.click();
 		}
         driver.findElement(By.xpath("(//span[normalize-space()='Add to cart'])[1]")).click();
        
				
		Thread.sleep(2000);
        TakesScreenshot scrshot= (TakesScreenshot)driver;
        File srcFile=scrshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("./screenshot2/screen1.png");
        FileUtils.copyFile(srcFile,destFile);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[1]")).click();
       driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
       driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
       driver.findElement(By.xpath("(//input[@type='checkbox'])")).click();
       driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
       driver.findElement(By.xpath("(//a[@title='Pay by bank wire'])")).click();
       driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
       WebElement screen = driver.findElement(By.xpath("(//h1[@class='page-heading'])"));
       JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView()",screen);
       File srcFile2=scrshot.getScreenshotAs(OutputType.FILE);
       File destFile2=new File("./screenshot2/screen2.png");
       FileUtils.copyFile(srcFile2,destFile2);
       
	}

}
  


