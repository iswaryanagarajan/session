package session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        
        SignupPageObjects sp=new SignupPageObjects(driver);
        sp.signUpfb();
        
        LoginPageObjects lp=new LoginPageObjects(driver);
        lp.loginfb();

	}

}
