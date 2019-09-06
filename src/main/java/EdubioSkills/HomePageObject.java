package EdubioSkills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	WebDriver driver;
	
	
	public HomePageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li[@id='nav-menu-item-8021']//span[@class='item_text'][contains(text(),'Products')]")
	WebElement Product;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[3]/div[1]/div[1]/ul[1]")
	WebElement productDropdown;
	
	
	@FindBy(xpath="//h3[contains(text(),'Our Product Categories')]")
	WebElement ProductHeadLine;
	
	public WebElement getProduct()
	{
	return Product;
}
	
		
	public WebElement getProductdropdown()
	{
	return productDropdown;
	}
}
