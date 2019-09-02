package EdubioSkills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseCode {

	public  static WebDriver driver;
	LoginPageObject lpo;
	Properties prop;
	HomePageObject hpo;

	public Properties getValues() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\manas\\eclipse-workspace\\edubioskills\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		return prop;
	}

	public void checkBrowser() {
		if ((driver.getTitle().contains("EdubioSkills – EdubioSkills"))) {
			System.out.println("Correct Browser is Opened");
		} else {
			System.out.println("Check:Wrong Browser Opened/No Browser is opened");
		}

	}

	public WebDriver gettingBrowser() throws IOException {
		getValues();

		String browser = prop.getProperty("browser");
		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\chromedriver_v75\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\work\\Drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.contains("IE")) {
			System.setProperty("webdriver.gecko.driver", "C:\\work\\Drivers\\IEDriver\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}

		
		return driver;

	}

	
	
}
