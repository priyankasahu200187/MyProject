package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class ProviderPage  extends TestBase {


	@FindBy(xpath="//app-send-message-button/button")
	WebElement Message;

	@FindBy(xpath="//textarea[@placeholder=\"Write a message\"]")
	WebElement WriteMessage;

	@FindBy(xpath="//button/span[text()=\" Send \"]")
	WebElement Send;

	@FindBy(xpath="//a[@ng-reflect-router-link=\"reviews\"]")
	WebElement Review;


	@FindBy(xpath="//button[@ng-reflect-closed-text=\"Write a Review\"]")
	WebElement WriteReview;

	@FindBy(xpath="//input[@aria-label=\"Title:\"]")
	WebElement Title;
	

	@FindBy(id="reviewText")
	WebElement YourReview;


	@FindBy(xpath="//div[@class=\"custom-control custom-checkbox\"]")
	WebElement certifycheck;

	@FindBy(xpath="//button/span[text()=\" Submit Review \"]")
	WebElement SubmitReview;



	//xpath="//label[text()="Your Rating"]/following-sibling::app-rating-field//div[1]/span"


    @FindBy(xpath="//div/span[contains(text(),\"Reviewed by\")]")
    WebElement ReviewVerify;



	public ProviderPage() throws Exception {

		super();
		
		PageFactory.initElements(driver, this);
	}


	public void sentMessageToProvider(String message) {
		
		//commonUtil.movetoelement(driver, Message);

		commonUtil.ClickElementWithJavaScript(driver, Message);

		String parent=	commonUtil.getWindowHandle(driver);
		//switch to message window
		String child=commonUtil.getWindowHandle(driver);

		commonUtil.switchToWindow(child, driver);

		commonUtil.enterText(driver, WriteMessage, message,"WriteMessage");

		commonUtil.clickOnButton(driver, Send,"Send");

		//switch to parent window
		commonUtil.switchToWindow(parent, driver);
		
		Reporter.log("Message is sent successfully");

	}
	
	public String writeReviewToProvider(String title,String review,int rating) {
		
	    commonUtil.clickOnButton(driver, Review,"Review");
		
		commonUtil.clickOnButton(driver, WriteReview,"WriteReview");
		
		commonUtil.enterText(driver, Title, title,"Title");
		
		commonUtil.enterText(driver, YourReview, review,"YourReview");
		
		//enter ratings based on user input
		
		
		  List<WebElement>list=driver.findElements(By.xpath("//label[text()=\"Your Rating\"]/following-sibling::app-rating-field//div[@class=\"simple-rating-stars__stars-bottom\"]/span"));
		  
		  for(int i=0;i<rating;i++) {
		  
		  list.get(i).click(); }
		 
		
	//	driver.findElement(By.xpath(")).click();
	//	driver.findElement(By.xpath("//label[text()=\"Your Rating\"]/following-sibling::app-rating-field//div[1]/span[2]")).click();
		
		commonUtil.clickOnButton(driver, certifycheck,"certifycheck");
		
		commonUtil.clickOnButton(driver, SubmitReview,"SubmitReview");
		
		String Reviewedby=ReviewVerify.getText();
		
		return Reviewedby;
		
	}

}
