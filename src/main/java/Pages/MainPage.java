package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class MainPage extends TestBase {




	@FindBy(className="header__login")

	WebElement LOGINLINK;

	@FindBy(xpath="//a/*[text()='Sign Up']")
	WebElement SignUp;

	@FindBy(id="username")

	WebElement USERID;

	@FindBy(id="current-password")

	WebElement PASSOWRD;

	@FindBy(xpath="//*[@type=\"submit\"]")


	WebElement SUBMIT;


	public MainPage() throws Exception {

		super();
		PageFactory.initElements(driver, this);
	}



	public  HomePage  signin(String userid,String password) throws Exception {

		commonUtil.clickOnButton(driver, LOGINLINK,"LOGIN Link");
		commonUtil.enterText(driver, USERID, userid,"USERID");
		commonUtil.enterText(driver, PASSOWRD, password,"PASSWORD");
		commonUtil.clickOnButton(driver, SUBMIT,"SUBMIT Button");
		return new HomePage();

	}
	
	public SignUpPage signup() throws Exception {
		 
		commonUtil.clickOnLink(driver, SignUp,"SignUP");
		return new SignUpPage();
	}

}
