package session1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver driver;
	  
	 
    public LoginPageObjects(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(id="email")
    public WebElement uname;
    
    @FindBy(id="pass")
    public WebElement pass;
    
    @FindBy(xpath="//*[@id=\"loginbutton\"]")
    public WebElement loginButton;
    
    public void loginfb()
    {
        uname.sendKeys("test123");
        pass.sendKeys("Passwd@123");
        loginButton.click();
}
}
