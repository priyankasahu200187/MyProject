package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import regression_zuddo.commonUtil;
import regression_zuddo.TestBase;

public class GroupPage extends TestBase{
	
	@FindBy(xpath="//a[text()=\" My Groups \"]")

	WebElement MyGroups;
	
	@FindBy(xpath="//app-category-tag[2]")
	WebElement ServiceCategory;
	
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton1;
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton2;
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton3;
	
	@FindBy(id="frequency")
	WebElement Frequency	;
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton4;
	
	@FindBy(id="description")
	WebElement description	;
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton5;
	
	@FindBy(xpath="//button[text()=\" Add a photo \"]")
	WebElement AddPhoto;
	
	
	@FindBy(xpath="//button/div[text()=\"Upload a photo\"]")
	WebElement UploadPhoto;
	
	@FindBy(xpath="//button[text()=\" Upload Photos \"]")
	WebElement UploadPhotos;
	
	@FindBy(xpath="//h2[text()='Add a description. ']/following-sibling::app-textarea//textarea")
	WebElement AddDescription;
	
	@FindBy(xpath="//button[@type=\"submit\"]/span[text()=\" Upload Photos \"]")
	WebElement uploadphotos;
	
	
	@FindBy(xpath="//button[@type=\"submit\"]/span[text()=\" Attach photo(s) \"]")
	WebElement AttachPhoto;
	
	@FindBy(xpath="//button[text()=\" Next \"]")
	WebElement NextButton6;
	
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement InputEmailFriend;

	
	@FindBy(xpath="//button[text()=\" Add \"]")
	WebElement AddButton;
	
	@FindBy(xpath="//button[text()=\" Submit \"]")
	WebElement Submit;
	
	
	
	@FindBy(xpath="//a[text()=\" Forming \"]")
	WebElement groupforming;
	
	@FindBy(xpath="//a[text()=\" Active \"]")
	WebElement groupactive;
	

	@FindBy(xpath="//app-campaign-list/*[1]")

	WebElement Groupbutton;
	
	@FindBy(xpath="//button/span[text()=\" Close Group \"]")
	WebElement CloseAlertButton;
	
	
	@FindBy(xpath="//app-campaign-details-sidebar-action/button[3]")
	WebElement CloseGroupButton;
	
	@FindBy(xpath="//app-campaign-status/div/div")
	WebElement GroupStatus;
	
	
	@FindBy(xpath="//app-campaign-details-sidebar-action/button[contains(text(),\"Join\")]")
	WebElement JointheGroupbtn;
	
	@FindBy(xpath="//span[@class=\"app-dropdown dropdown-toggle\"]")
	WebElement AddressDropdown;
	
	@FindBy(xpath="//label[@class=\"address-select-item__radio-label\"]")
	WebElement radiobutton;
	
	
	@FindBy(xpath="//app-campaign-details-sidebar-action/button[contains(text(),\"Leave this group\")]")
	WebElement Leavethisgroupbtn;
	
	@FindBy(xpath="//button[@type=\"submit\"]/span[contains(text(),\"Leave Group\")]")
	WebElement ConfirmLeavegroup;
	
	//messageOR
	
	@FindBy(xpath="//a[@ng-reflect-router-link=\"members\"]")
	WebElement memberstab;
	
	@FindBy(xpath="//a[@ng-reflect-router-link=\"offers\"]")
	WebElement offerstab;
	
	@FindBy(xpath="//app-campaign-member-owner-action/div[@class=\"dropdown\"]")
	WebElement messageicon;
	
	@FindBy(xpath="//app-campaign-member-owner-action//button[contains(text(),\" Message \")]")
	WebElement message;
	
	@FindBy(xpath="//textarea[@*=\"Write a message\"]")
	WebElement WriteMessage;
	
	
	
	@FindBy(xpath="//button/span[contains(text(),\"Send\")]")
	WebElement Sendbtn;
	
	@FindBy(xpath="//div[@class=\"header__actions-right app-text--menu\"]//*[@icon=\"envelope\"]")
	WebElement envelope;
	
	@FindBy(xpath="//div[@class=\"conversation-item__title\"][1]")
	WebElement Receivername;
	
	public GroupPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public String SendingMessageToMemeber(String membertype) {
		
		//launch the mygrouppage
		
		commonUtil.clickOnButton(driver, MyGroups,"MyGroup");
		//click on group
		commonUtil.clickOnButton(driver, groupactive,"ActiveGroup");
		
		//conndition to check the memebertype consumer/contractor
		if (membertype.contentEquals("consumer")) {
			
			commonUtil.clickOnButton(driver, memberstab,"MemeberTab");
			
		}
		else {
			
			commonUtil.clickOnButton(driver, offerstab,"OfferTab");
		}
	
		//click on message icon
		commonUtil.clickOnButton(driver, messageicon,"MessageICON");
		
		commonUtil.clickOnButton(driver, message,"MESSAGE");
		
		//switch to message window
		
		String child=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(child, driver);
		
		
		//enter the message and click sent button
		
		commonUtil.enterText(driver, WriteMessage, "Hello friend","WriteMessage");
		commonUtil.clickOnButton(driver, Sendbtn,"Send");
		//gotomessagetab
		commonUtil.clickOnButton(driver, envelope,"envelope");
		
		//verify the conversation was found //Receivername

		
		String receiver=Receivername.getText();
		
		return receiver;
		
		//login as the other member and verify the message is received
		
		
	}
	
	
	public String ReceiveingMessageFromMemeber() {
		
		//launch the mygrouppage
		
		commonUtil.clickOnButton(driver, MyGroups,"MyGroups");
		//click on envelope 
		commonUtil.clickOnButton(driver, envelope,"envelope");
	String sender=Receivername.getText();
		
		return sender;
		
	}
	
	
	public String joinGroup() {
		
		
		String detail="I need service to start every moday ,my other friends also need the same service";
		
		
		commonUtil.clickOnButton(driver, Groupbutton,"Groupbutton");
		
		commonUtil.clickOnButton(driver, JointheGroupbtn,"JointheGroupbtn");
		
		//commonUtil.clickOnButton(driver, AddressDropdown);
		
		//commonUtil.clickOnButton(driver, radiobutton);
		
		commonUtil.clickOnButton(driver, NextButton1,"NextButton1");

		commonUtil.enterText(driver, Frequency, "Sunday","Frequency");
		
		commonUtil.clickOnButton(driver, NextButton2,"NextButton2");
		
		//description
		commonUtil.enterText(driver, description, detail,"description");
		
		commonUtil.clickOnButton(driver, NextButton3," NextButton3");
		
		commonUtil.clickOnButton(driver, NextButton4,"NextButton4");
		
		commonUtil.clickOnButton(driver, Submit,"Submit");
		
		String child=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(child, driver);
		
		WebElement header= driver.findElement(By.xpath("//div[@class=\"modal-content\"]//h1"));
		String title=commonUtil.getTextfromElement(header);
		
		return title;
		
	}
	
	
	public boolean leaveGroup() throws InterruptedException {
		
		//click on mygroup  MyGroups  groupforming  ConfirmLeavegroup
		
		commonUtil.clickOnButton(driver, MyGroups,"MyGroups");
		commonUtil.clickOnButton(driver, groupforming,"groupforming");
		
		commonUtil.clickOnButton(driver, Groupbutton,"Groupbutton");
		
		String Memberbefore=driver.findElement(By.xpath("//a/span[contains(text(),\"Members\")]")).getText();
		
		commonUtil.clickOnButton(driver, Leavethisgroupbtn,"Leavethisgroupbtn");
		
		String child=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(child, driver);
		
		commonUtil.clickOnButton(driver, ConfirmLeavegroup,"ConfirmLeavegroup");
		
		Thread.sleep(3000);
		
		String Memeberafter=driver.findElement(By.xpath("//a/span[contains(text(),\"Members\")]")).getText();
		
		Reporter.log(Memberbefore );
		Reporter.log(Memeberafter );
		
		if (Memberbefore.contentEquals(Memeberafter)) {
			
			return false;
		}
		else {
			return true;
		}
	}
	
public String  closeGroup() throws InterruptedException {
		
		
		try {
			commonUtil.clickOnLink(driver, MyGroups," MyGroups");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			commonUtil.clickOnLink(driver, MyGroups," MyGroups");
		}
		
		commonUtil.movetoelement(driver, groupforming);//click on status with name "Forming"
		
		commonUtil.clickOnButton(driver, Groupbutton," Groupbutton'");//click on group icon listed with forming status
		
		Thread.sleep(8000);
		
		String parent=driver.getWindowHandle();
		
		//Groupbutton
		
		commonUtil.clickOnButton(driver, CloseGroupButton,"CloseGroupButton");
		
		
	
		String alert=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(alert, driver);
		
	
		
		commonUtil.clickOnButton(driver, CloseAlertButton,"CloseAlertButton");
		
		
		driver.switchTo().window(parent);
		
		String Status=GroupStatus.getText();
		return Status;
		
	}
	
	
	public void createNewGroup() throws Exception {
		
		
		String detail="I need service to start every moday ,my other friends also need the same service";
		
		String FriendEmail=prop.getProperty("friendemail");
		
		commonUtil.clickOnButton(driver, ServiceCategory,"ServiceCategory");
		commonUtil.clickOnButton(driver, NextButton1,"NextButton1");
		commonUtil.clickOnButton(driver, NextButton2,"NextButton2");
		commonUtil.clickOnButton(driver, NextButton3,"NextButton3");
		commonUtil.enterText(driver, Frequency, "Monday","Frequency");
		
		
		
		commonUtil.clickOnButton(driver, NextButton4,"NextButton4");
		
		commonUtil.enterText(driver, description,detail,"description");
		
		commonUtil.clickOnButton(driver, NextButton5,"NextButton5");
		
		//call function to add photo
		
		addPhotoGroup();
		
		
	
		
		
		  commonUtil.clickOnButton(driver, NextButton6,"NextButton6");
		  
		  commonUtil.enterText(driver, InputEmailFriend,FriendEmail,"InputEmailFriend");
		  
		  
		  
		  commonUtil.clickOnButton(driver, AddButton,"AddButton");
		  
		  
		  commonUtil.clickOnButton(driver, Submit,"Submit");
		 
		
		}
	
	
	public void addPhotoGroup() throws Exception {
		
		
		String path=prop.getProperty("photopath");
		
		String parent=driver.getWindowHandle();
		commonUtil.clickOnButton(driver, AddPhoto,"AddPhoto");
		
		String child1=commonUtil.getWindowHandle(driver);
		commonUtil.switchToWindow(child1, driver);
		commonUtil.clickOnButton(driver, UploadPhoto,"UploadPhoto");
		
		String child2=commonUtil.getWindowHandle(driver);
		
		commonUtil.switchToWindow(child2, driver);
		commonUtil.clickOnButton(driver, UploadPhotos,"UploadPhotos");
		
		commonUtil.LoadFile(driver, path);
		commonUtil.enterText(driver, AddDescription, "hello","AddDescription");
		commonUtil.clickOnButton(driver, uploadphotos,"uploadphotos");
		
		String child3=commonUtil.getWindowHandle(driver);
		
		commonUtil.switchToWindow(child3, driver);
		//AttachPhoto
		
		commonUtil.clickOnButton(driver, AttachPhoto,"AttachPhoto");
		
		commonUtil.switchToWindow(parent, driver);
		
		}

	
	public String confirmWindowPopup() {
		
		
		driver.findElement(By.xpath("//button/span[text()=\" OK \"]")).click();
		String title=driver.findElement(By.xpath("//div[@class=\"app-text--h1 campaign-details-header__title\"]")).getText();
		return title;
	}
	
	

}
