package regression_zuddo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.GroupPage;
import Pages.HomePage;
import Pages.MainPage;
import regression_zuddo.TestBase;

public class GroupPageTest extends TestBase {
	
	MainPage mainpage;
	HomePage homepage;
	GroupPage grouppage;

	public GroupPageTest() throws Exception {
		// TODO Auto-generated constructor stub
		super();
	}

	
	@BeforeMethod

	public void setup() throws Exception {

		mainpage=	TestBase.browserLaunch();
		homepage=mainpage.signin(prop.getProperty("username"),prop.getProperty("password"));
		grouppage=	homepage.launchGroupPage();
	}
	
	
	@Test(enabled=false)
	public void TC_UI010_Messaging1() {
		
		String receiver=grouppage.SendingMessageToMemeber("consumer");
		
		Assert.assertEquals(receiver,"Priyanka");		
	}
	
	
	@Test(enabled=false)
	public void TC_UI010_Messaging2() {
		
		String sender=grouppage.ReceiveingMessageFromMemeber();
		
		Assert.assertEquals(sender,"RaviKumar");		
	}
	
	
	
	@Test (enabled=false)
	public void Test_UI005_002() throws Exception {
		
	String result=grouppage.closeGroup();

		Assert.assertEquals(result,"CLOSED");
	}
	

	
	@Test (priority=2,enabled=true)
	public void Test_UI005_001() throws Exception {
		
		grouppage.createNewGroup();
		String title=grouppage.confirmWindowPopup();
		
		Reporter.log("title");
		Assert.assertEquals(title, prop.getProperty("groupcategoryname"));
	
	}
	
	
	
	@Test(priority=3,enabled=true)
	public void Test_UI009_JoinGroup() {
		//call join group function
		String title= grouppage.joinGroup();
		//veirfy title 
		Reporter.log(title);
		Assert.assertEquals(title, "You joined a group! What's next?","title of the page is"+title);
	}
	
	@Test(priority=4,enabled=true)
	public void TestUI009_LeaveGroup() throws InterruptedException {
		//call join group function
	boolean actual= grouppage.leaveGroup();
	
	Assert.assertEquals(actual, true,"Successfully left the group");
	
	}
	

	@AfterMethod

	public void teardown() {

	driver.close();


	}
}
