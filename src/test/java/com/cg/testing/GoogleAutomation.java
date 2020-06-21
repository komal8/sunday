package com.cg.testing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class GoogleAutomation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Creo\\chromedriver_win32 (6)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().fullscreen();
WebElement SearchBtn=		driver.findElement(By.xpath("//*[@name='q']"));
SearchBtn.sendKeys("capgemini India");
SearchBtn.submit();
if(driver.getTitle().equalsIgnoreCase("capgemini India-Google search")) {
	System.out.println("on correct page");
}
else {
	System.out.println("we are not on correct page");
}



/*List<WebElement>links=driver.findElements(By.tagName("a"));
int totallinks=links.size();
System.out.println("total"+totallinks);
for(int i=0;i<totallinks;i++) {
String text=	links.get(i).getText();
System.out.println("Text of the links"+text);
links.get(i).click();
}*/
		try {
			takesScreenshot(driver,"Google_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void takesScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
	File src=	ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".//picture//"+ScreenshotName+".png");
	FileHandler.copy(src, dest);
		
	}

}
