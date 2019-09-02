package EdubioSkills;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;
	BaseCode bc=new BaseCode();
	Properties prop;
	int ticker=0;
	LoginPageObject lpo;
	
	@BeforeMethod
	public void getWebsite() throws IOException
	{
		driver=bc.gettingBrowser();
		driver.get("https://www.edubioskills.com/");
		driver.manage().window().maximize();
		prop=(Properties) bc.getValues();
	}
	
	@AfterMethod
	public void closeWebsite()
	{
		driver.quit();
		driver=null;
	}
	
	@Test
	public void Blogin() throws InterruptedException, IOException
	{
		ticker=2;
		String un=prop.getProperty("un1");
		String pw=prop.getProperty("pw1");
		login(un,pw,ticker);
	}
	
	@Test
	public void Alogin() throws InterruptedException
	{
		ticker=1;
		String un=prop.getProperty("un2");
		String pw=prop.getProperty("pw2");
		login(un,pw,ticker);
	}
	
	public void login(String username, String password, int value) throws InterruptedException {
		// TODO Auto-generated method stub

		lpo = new LoginPageObject(driver);
		System.out.println("Login A Tests");
		WebElement LoginButton = lpo.loginButton();

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();

		Thread.sleep(2000);

		Set<String> wh = driver.getWindowHandles();
		Iterator<String> iwh = wh.iterator();
		String parentHandle;

		while (iwh.hasNext()) {
			parentHandle = iwh.next();
			if (driver.getTitle().contains("Signin")) {

				System.out.println(driver.getTitle());

				Thread.sleep(2000);
				WebElement UN = lpo.Username();
				WebElement PW = lpo.Password();
				WebElement GO = lpo.Submit();

				Thread.sleep(2000);
				UN.sendKeys(username);
				PW.sendKeys(password);
				GO.click();
				// Back to parent handle

				if (value == 1) {

					driver.switchTo().window(parentHandle);
					//Thread.sleep(2000);
					System.out.println(lpo.WelcomeMessage().getText());
					Assert.assertEquals(lpo.WelcomeMessage().getText(), "Welcome, test1|Logout");
					
				} else if (value == 2) {
					Assert.assertTrue(lpo.errormessage.isDisplayed());
					Assert.assertEquals(lpo.ErrorMessage(), "The username or password you entered is invalid");
					System.out.println(lpo.ErrorMessage());
				}
			}
		}
	}
}
