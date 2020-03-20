package session1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiwindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	          driver.get("http://demo.automationtesting.in/Windows.html");
	       
	          WebElement wb=driver.findElement(By.xpath("//*[@id='Tabbed']/a/button"));
	          wb.click();
	         
	          Thread.sleep(3000);
	         
	          Set<String> set=driver.getWindowHandles();
	         
	          Iterator<String> it=set.iterator();
	         
	          String window0=it.next();
	         
	          String window1=it.next();
	         
	         
	          driver.switchTo().window(window1);
	         
	          System.out.println("child window pop-up title:"+ driver.getTitle());
	         
	          Thread.sleep(3000);
	          driver.findElement(By.xpath("(//*[@href='contact.php'])[2]")).click();
	         
	          Thread.sleep(2000);
	          driver.switchTo().window(window1);
	         
	          System.out.println("parent window pop-up title:"+ driver.getTitle());
	         
	          Thread.sleep(3000);
	          driver.findElement(By.xpath("//*[@href='Index.html']")).click();
	 

	}

}
