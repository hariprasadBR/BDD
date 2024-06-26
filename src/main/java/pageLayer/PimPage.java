package pageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.BaseClass;
import utilLayer.Waits;

public class PimPage extends BaseClass{
	
	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[2]")
	private WebElement pim;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	private WebElement addElement;
	
	@FindBy(name="firstName")
	private static WebElement firstname;
	
	@FindBy(name="lastName")
	private WebElement lastname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath="//a[text()='Employee List']")
	private WebElement empList;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement employeeId;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement searcbutton;
	
	@FindBy(xpath="//div[text()='Id']/following::input[1]")
	WebElement checkElement;

	@FindBy(xpath="//button[text()=' Delete Selected ']")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement confirmDelete;

	@FindBy(xpath="//span[text()='No Records Found']")
	WebElement noRecords;
	
	public PimPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPim() {
		Waits.click(pim);
	}
	
	public  void addData(String fname ,String lname) {
		
		Waits.click(addElement);
		Waits.sendKeys(firstname, fname);
		
		Waits.sendKeys(lastname, lname);
		Waits.click(saveButton);
	}
	
	public String captureEidandClickOnEmployeeList()
	{
		String eid=Waits.getAttribute(employeeId,"value");
		Waits.click(empList);
		return eid;
	}
	public void  clickOnSearch(String eid)
	{
		Waits.sendKeys(employeeId,eid);		
		Waits.click(searcbutton);
		
			
	}
	public void checkElementAndDelete() throws InterruptedException
	{
		Thread.sleep(5000);
//		Wait.click(checkElement);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",checkElement);
		Waits.click(deleteButton);
		Waits.click(confirmDelete);
	}
	public String checkDeleteOrNot(String eid)
	{

		Waits.sendKeys(employeeId,eid);		
		Waits.click(searcbutton);
		String msg=Waits.gettext(noRecords);
		return msg;
				
		
	}
	

}
