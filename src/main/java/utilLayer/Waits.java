package utilLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseLayer.BaseClass;

public class Waits extends BaseClass{
	
	public static WebElement visiblitystatus(WebElement wb) {
		
		return new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(wb));
	}
	
	public static List<WebElement> visibilityAllElement(WebElement wb){
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(wb));
	}
	
	
	public static List<WebElement> visibilityAllElement(List<WebElement>  wb){
		
	return new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(wb));
	}
	
	public static Alert alertIsPersent() {
		
		return  new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static void sendKeys(WebElement wb, String value) {
		
		visiblitystatus(wb).sendKeys(value);
	}
	
	public static void click(WebElement wb ) {
		visiblitystatus(wb).click();
	}
	
	
	public static void clear(WebElement wb) {
		
		visiblitystatus(wb).clear();
	}
	
	public static String gettext(WebElement wb) {
		return visiblitystatus(wb).getText();
	}
	
	
	public static String getAttribute(WebElement wb,String value) {
		
		return visiblitystatus(wb).getAttribute(value);
		
	}
	
	public static boolean isselcted(WebElement wb) {
		
		return visiblitystatus(wb).isSelected();
	}
	
	public static void selectAnyone(List<WebElement> wb, String value) {
	    for (WebElement a : wb) {
	        if (a.getText().equals(value)) {
	            a.click();
	            break;
	        }
	    }
	}

}
