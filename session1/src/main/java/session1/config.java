package session1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class config {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		BufferedReader buffer=new BufferedReader(new FileReader("/home/lkb-l-039/eclipse-workspace/session1/src/main/java/session1/config properties"));
		Properties prop=new Properties();
		prop.load(buffer);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.id("pass")).sendKeys("passwrd");
		driver.findElement(By.id("loginbutton")).click();

	}

}
