package EdubioSkills;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTabs extends BaseCode {
	WebDriver driver;

	HomePageObject hpo;

	BaseCode bc = new BaseCode();
	Properties prop;

	@BeforeMethod
	public void getWebSite() throws IOException {
		driver = bc.gettingBrowser();
		driver.get("https://www.edubioskills.com/");
		driver.manage().window().maximize();
		prop = (Properties) bc.getValues();

	}

	@Test
	public void AProductCategories() throws InterruptedException, IOException {
		hpo = new HomePageObject(driver);
		hpo.Product.click();
		System.out.println("Our Product Categories");
		Assert.assertTrue(hpo.ProductHeadLine.isDisplayed());
	}

	@AfterMethod
	public void closeWebsite() {
		driver.quit();
		driver = null;
	}

}
