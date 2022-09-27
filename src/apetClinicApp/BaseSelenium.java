package apetClinicApp;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSelenium {

	public WebDriver driver;
	String url = "https://petclincqpros.herokuapp.com/";

	@Before
	public void setUp() {
		// Set the key/value property according to the browser you are using.
		System.setProperty("webdriver.chrome.driver", "/home/diana/Downloads/chromedriver");

		// Open browser instance
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the AUT
		driver.get(url);

	}

	@After
	public void tearDown() {
		// Close the browser
		driver.close();
	}

}