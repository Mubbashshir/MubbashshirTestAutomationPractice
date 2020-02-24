package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import cucumber.api.java.After;

//This is base file for declaring drivers 
public class TestBase {

	public static Properties CONFIG = null;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public void initialize() throws IOException {
		
		if (driver == null) {
		

			CONFIG = new Properties();

			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\Utils\\config.properties");
			CONFIG.load(fi);
               
			if (CONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
				// user will need to specify the location of their chrome driver
				// to run this
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\java\\chromedriver.exe");
				driver = new ChromeDriver();
				

			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		
		
	}

	
}

