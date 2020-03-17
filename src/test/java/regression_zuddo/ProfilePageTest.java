package regression_zuddo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.MainPage;
import Pages.ProfilePage;
import regression_zuddo.TestBase;

public class ProfilePageTest extends TestBase {

	HomePage homepage;
	MainPage mainpage;
	ProfilePage profilepage;
	public ProfilePageTest() throws Exception {
		super();

	}

	@BeforeMethod

	public void setup() throws Exception {

		mainpage=	TestBase.browserLaunch();

		homepage=mainpage.signin(prop.getProperty("username"),prop.getProperty("password"));


		try {
			homepage.clickOnProfileLink();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			homepage.clickOnProfileLink();
		}

		profilepage=homepage.launchProfile();

	}

	@Test(enabled=false)
	public void TC_UI004() throws Exception {
		
		Reporter.log("Objective:Create your profile");
		profilepage.editprofileclick();

		profilepage.photoUpload();
		
	}

	
	@Test(enabled=true)
	
	public void TC_UI008() throws InterruptedException {
		
		profilepage.editprofileclick();
		
		boolean actual=profilepage.verifyEditProfile();
		
		Assert.assertEquals(actual, true);
	}

	
}
