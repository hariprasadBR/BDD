package baseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {

		File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\configurationLayer\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(f);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void intilization(String browsername) {
		{
			if (browsername.equalsIgnoreCase(null)) {
				System.out.println("Not selected the browser");
			} else {
				if (browsername.equalsIgnoreCase("chrome")) {

				} else if (browsername.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else if (browsername.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else if (browsername.equalsIgnoreCase("headless")) {
					ChromeOptions chromeOptions = new ChromeOptions();

					chromeOptions.addArguments("--headless");
					driver = new ChromeDriver(chromeOptions);
				} else if (browsername.equalsIgnoreCase("--inciginto")) {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--incognito");
					driver = new ChromeDriver();
				}

			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().deleteAllCookies();
			String url = prop.getProperty("url");
			driver.get(url);

		}

	}
}
