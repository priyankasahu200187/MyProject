package regression_zuddo;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.MainPage;

public class TestBase {

	public static  Properties prop;
	public static WebDriver driver =null;
	public static FileInputStream fin;
	public  TestBase() throws Exception{

		prop=new Properties();

		FileInputStream ip=new FileInputStream("C:\\Users\\ravin\\Desktop\\HR_domain\\regression_zuddo\\src\\main\\java\\regression_zuddo\\config.properties");

		prop.load(ip);
	}


	public static MainPage browserLaunch() throws Exception {


		String browserName= prop.getProperty("Browser");
		String url=prop.getProperty("URL");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravin\\Downloads\\Chrome\\chromedriver_win32 (1)\\chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return new MainPage();

	}

}
