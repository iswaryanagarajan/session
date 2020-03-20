package session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class draganddrop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		 WebElement sourceLocator = driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		 WebElement targetLocator = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		 Actions action = new Actions(driver);
		 action.dragAndDrop(sourceLocator, targetLocator).build().perform();

	}

}
