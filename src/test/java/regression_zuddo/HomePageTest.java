package regression_zuddo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import regression_zuddo.commonUtil;
import Pages.GroupPage;
import Pages.HomePage;
import Pages.MainPage;
import Pages.ProfilePage;
import Pages.SignUpPage;
import regression_zuddo.TestBase;

public class HomePageTest extends TestBase {

	MainPage mainpage;
	HomePage homepage;
	SignUpPage signuppage;
	GroupPage grouppage;

	ProfilePage profilepage;





	public HomePageTest() throws Exception {

		super();



	}

	

	@BeforeMethod

	public void setup() throws Exception {

		mainpage=	TestBase.browserLaunch();


	}


	@Test(enabled=false)
	public void TC_UI001() throws Exception {

		signuppage=mainpage.signup();
		signuppage.signUpUser();

		String title=commonUtil.getTitle(driver);
		Assert.assertEquals(title, "Please confirm your email");
		   
	}


	@Test(priority=1,enabled=true)

	public void TC_UI002() throws Exception {
		
		 System.out.println("test case is executing");	

		homepage=mainpage.signin(prop.getProperty("username"),prop.getProperty("password"));
		String title=commonUtil.getTitle(driver);
		
	 

		Assert.assertEquals(title, "Welcome back to Zuudoo!");
		
		
	}


	@AfterMethod

	public void teardown() {

	driver.close();


	}





}
