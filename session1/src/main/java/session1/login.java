package session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	public static void main(String[] args) {
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "Desktop/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://stag-products.bafsolution.com/");
		driver.findElement(By.name("email")).sendKeys("products.bafsolution@gmail.com");
		driver.findElement(By.id("passowrd")).sendKeys("Lakeba@123");
		driver.findElement(By.id("login")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	}

}
