package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class ProfilePage extends TestBase{

	@FindBy(css="[icon=\"edit\"]")
	WebElement EditProfile;
	
	@FindBy(css="[type=\"submit\"]")
	WebElement Save;
	
	@FindBy(id="display_name")
	WebElement Displayname;
	

	@FindBy(id="aboutTextArea")
	WebElement AboutYourself;
	
	@FindBy(xpath="//div[@class=\"app-text--h1 profile-header__name\"]")
	WebElement NameOnHeader;
	
	@FindBy(xpath="//app-description[@class=\"d-block\"]/span")
	WebElement About;

	@FindBy(className="modal__reject-btn app-btn--grey ng-star-inserted")
	WebElement CancelButton;
	
	
	
	@FindBy(xpath="//label[@for=\"display_name\"]/following-sibling::input")
	WebElement Displaytext;
	
	@FindBy(tagName="textarea")
	WebElement Discriptiontext;

	@FindBy(xpath="//button[text()=\"Profile \"]")

	WebElement Profile;

	@FindBy(xpath="//a[text()=\" Change Picture \"]")
	WebElement ChangePicture;

	@FindBy(xpath="//button[@type=\"submit\"]/*[text()=\" Crop Image \"]")
	WebElement Cropimage;
	
	
	public ProfilePage() throws Exception {
		super();
		commonUtil.waitForPageToLoad(driver);
		PageFactory.initElements(driver, this);

	}
	
	
	


	public boolean verifyEditProfile() throws InterruptedException {
		
		
		commonUtil.enterText(driver, Displayname, prop.getProperty("display"),"Displayname");
		Thread.sleep(3000);
		commonUtil.enterText(driver, AboutYourself,prop.getProperty("aboutuser"),"AboutYourself");
		Thread.sleep(3000);
		commonUtil.clickOnButton(driver, Save,"Save Button");
		
		Thread.sleep(9000);
		
		String nameonheader=commonUtil.getTextfromElement(NameOnHeader);
		String about=commonUtil.getTextfromElement(About);
		
		if(nameonheader.contentEquals(prop.getProperty("display")) && about.contentEquals(prop.getProperty("aboutuser")) ) {
			
			return true;
		}
		
		else {
			System.out.println(nameonheader+"||"+prop.getProperty("display"));
			
			System.out.println(about+"||"+prop.getProperty("aboutuser"));
			return false;
		}
		
	}
	
	
	public void verifyReviewTab() {
		
		
	}
	
	
	public void verifyMygroupTab() {
		
		
	}

	public void editprofileclick() {

	commonUtil.s
	}


	public void photoUpload() throws Exception {


		//switch to profile picture window

		String Window=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(Window, driver);

		// display picture window 
		commonUtil.clickOnButton(driver, ChangePicture,"ChangePicture");


		//load picture using robot class
	
		commonUtil.LoadFile(driver, prop.getProperty("photopath"));
		//System.out.println("photo is loading..."); 

		
		
		//switch to crop window

		Window=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(Window, driver);


		//crop image window 
		commonUtil.clickOnButton(driver, Cropimage,"CropImage");
		
		//enter Display name and discription
		
		commonUtil.enterText(driver, Displaytext, prop.getProperty("displayname"),"Displayname");
		commonUtil.enterText(driver, Discriptiontext, prop.getProperty("Address"),"Discription");
		
		//click on save button
		
		commonUtil.clickOnButton(driver, Save,"SaveButton");

		
	}

}
