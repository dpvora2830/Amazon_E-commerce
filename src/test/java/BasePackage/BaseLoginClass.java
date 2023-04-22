package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//browser info
//url info
//username & password
public class BaseLoginClass {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public BaseLoginClass() {
		try {
			FileInputStream file = new FileInputStream("C:\\Selenium_WorkSpace\\Myworks\\Amazon_E-commerce\\src\\test\\java\\EnvironmentVariables\\Config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void setup() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions copt = new ChromeOptions();
			copt.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(copt);
		}
		else if(browserName.equals("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));//to get url
		
	}
		
}
