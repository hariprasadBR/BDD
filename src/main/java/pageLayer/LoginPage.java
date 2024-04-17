package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;
import utilLayer.Waits;

public class LoginPage extends BaseClass{
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void loginFunctionality(String uname,String pass) {
		Waits.sendKeys(username, uname);
		Waits.sendKeys(password, pass);
		Waits.click(loginButton);
	}

}
