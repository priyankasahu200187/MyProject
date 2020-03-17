package regression_zuddo;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import regression_zuddo.commonUtil;

public class commonUtil {

public static void movetoelement(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}


public static String getTextfromElement(WebElement element) {
	

	return element.getText();
}
	
public static WebElement wait(WebDriver driver,WebElement element) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return element;
}


public static void ClickElementWithJavaScript(WebDriver driver, WebElement element) {
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
	
}

public static void clickOnButton(WebDriver driver, WebElement element,String elementname) {
	
	wait(driver, element);
	
	if (element.isEnabled()) {
	

		for(int i=0; i<=2;i++){
			  try{
			    element.click();
			    System.out.println(elementname+" is clicked");
			     break;
			  }
			  catch(Exception e){
				  System.out.println(e.getMessage());
			  }
			}
}
	
	else {
		
		System.out.println("Button  is not displayed");
		Assert.fail("Button is not displayed");
	}

}	


public static void clickOnLink(WebDriver driver, WebElement element,String elementname) {
	
	if (commonUtil.wait(driver, element).isDisplayed()) {
	

		try {
			element.click();
			 System.out.println(elementname+" is clicked");
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			element.click();
		}
}
	
	else {
		
		System.out.println("Link  is not displayed");
		Assert.fail("Button is not displayed");
	}

}	



public static void LoadFile(WebDriver driver,String path) throws Exception {
	
	
	// Specify the file location with extension
	 StringSelection sel = new StringSelection(path);
	 
	   // Copy to clipboard
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	 System.out.println("selection" +sel);
	 
	 
	// Create object of Robot class
	 Robot robot = new Robot();
	 Thread.sleep(1000);
	      
	  // Press Enter
	 robot.keyPress(KeyEvent.VK_ENTER);
	 
	// Release Enter
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	  // Press CTRL+V
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 
	// Release CTRL+V
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(1000);
	        
	        // Press Enter 
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 
	
}

public static void enterText(WebDriver driver,WebElement element,String value,String elementname) {
	
	if (element.isEnabled()) {
		
		element.clear();
		element.sendKeys(value);
		  System.out.println(elementname+" value is entered");
	}
	
	else {
		
		Assert.fail("values cannot be typed in");
	}
}

public static String getWindowHandle(WebDriver driver) {
	String Window=driver.getWindowHandle();
	return Window;
	
}

public static WebDriver switchToWindow(String window,WebDriver driver) {
	
	driver.switchTo().window(window);
	return driver;
}

public static WebElement fluentWait(WebDriver driver,final WebElement element) {
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(30, TimeUnit.SECONDS) 			
			.pollingEvery(5, TimeUnit.SECONDS) 			
			.ignoring(NoSuchElementException.class);
	WebElement elementclick = wait.until(new Function<WebDriver, WebElement>(){
		
		public WebElement apply(WebDriver driver ) {
			return element;
		}
	});
	
	return elementclick;
}

public static void waitForPageToLoad(WebDriver driver) {
ExpectedCondition<Boolean> pageLoadCondition = new
ExpectedCondition<Boolean>() {
public Boolean apply(WebDriver driver) {
return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
}
};
WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(pageLoadCondition);
}


public static String getTitle(WebDriver driver) {
	
	String title=driver.getTitle();
	return title;
}

public static void refreshPage(WebDriver driver) {
	
	driver.navigate().refresh();
	
}

	


}
