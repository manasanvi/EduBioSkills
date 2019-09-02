package EdubioSkills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;

	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="mo_oauth_widget-2")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//input[@name='signInSubmitButton']")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//p[@id='loginErrorMessage']")
	WebElement errormessage;
	
	@FindBy(linkText="Sign up")
	WebElement signup;

	@FindBy(id="mo_oauth_widget-2")
	WebElement welcomemesg;
	
	
	public WebElement loginButton()
	{
		return LoginButton;
	}
	
	public WebElement Username()
	{
		return username;
	}
	
	public WebElement Password()
	{
		return password;
	}
	
	public WebElement Submit()
	{
		return submit;
	}
	
	public String ErrorMessage()
	{
		return errormessage.getText();
	}
	
	public WebElement SignUp()
	{
		return signup;
	}
	
	public WebElement WelcomeMessage()
	{
		return welcomemesg;
	}
	
}
