package session1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageObjects {
	WebDriver driver;
	 public SignupPageObjects(WebDriver driver) {
		    this.driver=driver;
	        PageFactory.initElements(driver, this);
	 }
	 	@FindBy(name="websubmit")
	    public WebElement SignupBtn;
	    
	    @FindBy(name="firstname")
	    public WebElement firstName;
	    
	    @FindBy(xpath="//*[@name='sex']")
	    public List<WebElement> gender;



public void signUpfb()
{
   //wait1=new WebDriverWait(driver, 100);
   //wait1.until(ExpectedConditions.visibilityOf(SignupBtn));
   SignupBtn.click();
   
   //wait1.until(ExpectedConditions.visibilityOf(firstName));
   firstName.sendKeys("Iswarya");
   
   //wait1.until(ExpectedConditions.visibilityOfAllElements(gender));
   
   
   for(int i=0;i<gender.size();i++)
   {
       gender.get(i).click();
   }
   
}
}
