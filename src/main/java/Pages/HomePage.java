package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class HomePage extends TestBase {


	@FindBy(className="dropdown")
	WebElement ProfileImage;

	@FindBy(xpath="//button[text()=\"Profile \"]")

	WebElement Profile;

	@FindBy(xpath="//a/*[text()=\"Groups\"]")

	WebElement GroupIcon;


	@FindBy(xpath="//a[text()=\" My Groups \"]")

	WebElement MyGroups;
	
	@FindBy(linkText="Active")
	WebElement StatusActive;

	
	@FindBy(xpath="//app-campaign-list/app-campaign-item[1]//div//a/u")
	WebElement ActiveGroupObject1;



	@FindBy(xpath="//button[@class=\"d-block w-100 app-btn--secondary app-margin__sm--b ng-star-inserted\" and contains( text(),' Close the group')]")

	WebElement CloseGroupButton;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement CloseButton;

	
	@FindBy(xpath="//a/span[text()=\"Start a new group\"]")
	WebElement StartNewGroup;
	
	
	public HomePage() throws Exception {
		super();

		PageFactory.initElements(driver, this);

	}
	
	
	
	public void launchMyGroupPageActiveStatus() {
		
		commonUtil.clickOnLink(driver, MyGroups,"MyGroups button");
		System.out.println("MyGroupPage is launched");
		commonUtil.clickOnLink(driver, StatusActive,"Status=Active");
		System.out.println("Groups with active status  is launched");
	}
	
	
	
	
	
	public ProviderPage launchProvidePage() throws Exception {
		
		
	String ProviderName=	ActiveGroupObject1.getText();
	
	System.out.println("Service Provider for group is "+ProviderName);
	
	commonUtil.clickOnButton(driver, ActiveGroupObject1,"ActiveGroupTab");
	
	return new ProviderPage();
		
	}


	public void clickOnProfileLink() {

		commonUtil.clickOnButton(driver, ProfileImage,"ProfileImage");
		System.out.println("Profilelink is clicked");
	}	
	
	


	public ProfilePage launchProfile() throws Exception {

		commonUtil.clickOnButton(driver, Profile,"profile button");
		System.out.println("Profile is clikded)");


		return new ProfilePage();
	}
	
	public GroupPage launchGroupPage() throws Exception {
		
		//click on group icon
		commonUtil.clickOnLink(driver, GroupIcon,"Group tab");
		return new GroupPage();
		
	}


	public GroupPage launchNewGroupPage() throws Exception {
		
		//click on group icon
		commonUtil.clickOnLink(driver, StartNewGroup,"StartNewGroup");
		return new GroupPage();
		
	}
}
