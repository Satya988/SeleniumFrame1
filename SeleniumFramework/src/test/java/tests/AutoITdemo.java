package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITdemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://easyupload.io/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='dz-button']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\fileupload.exe");
		Thread.sleep(3000);

	}

}
