package regression_zuddo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.MainPage;
import Pages.ProviderPage;
import regression_zuddo.TestBase;

public class ProviderPageTest extends TestBase {


	MainPage mainpage;
	HomePage homepage;
	ProviderPage providerpage;


	public ProviderPageTest() throws Exception {

		super();
	}


	@BeforeMethod

	public void setup() throws Exception {

		mainpage=	TestBase.browserLaunch();
		homepage=mainpage.signin(prop.getProperty("username"),prop.getProperty("password"));
		homepage.launchMyGroupPageActiveStatus();
		providerpage=homepage.launchProvidePage();

	}

	@Test(enabled=false)


	public void UI007(){



		providerpage.sentMessageToProvider(prop.getProperty("message_provider"));

		//int rating=	Integer.parseInt(prop.getProperty("rating"));

		String Reviewedby=providerpage.writeReviewToProvider(prop.getProperty("title"), prop.getProperty("review"), 3);

		String expected="Reviewed by "+prop.getProperty("username");

		boolean result=Reviewedby.contains(expected);

		System.out.println(result);
		System.out.println(expected);
		
		Assert.assertEquals(result, true);
		//assert.assertEquals(result, true);
	}
	

}
