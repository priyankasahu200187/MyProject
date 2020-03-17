package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(id="username")
	WebElement Name;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="new-password")
	WebElement Password;
	
	@FindBy(xpath="//label/*[text()=\"Find a professional\"]")
	WebElement Professional;
	

	
	@FindBy(xpath="//label/*[text()=\"Sell my services\"]")
	WebElement ServiceProvider;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement SignUpButton;
	
	public SignUpPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	
	
	public void signUpUser() {
		
		
		
		String usercategory=prop.getProperty("Newname");
		String[] user=usercategory.split("_");
		commonUtil.enterText(driver,Name,user[0],"USERNAME");
		commonUtil.enterText(driver,Name, prop.getProperty("NewEmail"),"EMAIL");
		commonUtil.enterText(driver,Name, prop.getProperty("NewPassword"),"PASSWORD");
		
		
		
		if(user[1].contentEquals("professional")) {
		
		commonUtil.clickOnButton(driver, Professional,"Professional");
		}
		else {
			
			commonUtil.clickOnButton(driver, ServiceProvider,"ServiceProvider");
		}
		
		if (SignUpButton.isEnabled()) {
			
			SignUpButton.click();
		}
		else {
			
			Assert.fail("signUp validatio is failed for creating new user...refer screenshot");
		}
		
		
	}
	

}
