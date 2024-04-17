package stepDefination;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseLayer.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageLayer.LoginPage;
import pageLayer.PimPage;

public class StepDefinationClass extends BaseClass{
	
	PimPage pim = new PimPage();
	String eid;
	
	@Given("user enter{String} browser and open login url")
	public void user_enter_browser_andopen_login_url (String browserName) {

}

@When("user enter valid creditial and click on login button")
public void user_enter_valid_creditial_and_click_on_login_button() {
	LoginPage loginPage = new LoginPage();
	loginPage.loginFunctionality("Admin", "admin123");
}

@Then("user validate Title")
public void user_validate_Title() {
	String pagetitle = driver.getTitle();
	Assert.assertEquals(pagetitle, "OrangeHRM");
}

@Then("user validate url")
public void user_validate_url() {
	String pageUrl = driver.getCurrentUrl();
	boolean b = pageUrl.contains("index");
	Assert.assertEquals(b, true);
}

@When("user Click on pim page")
public void user_Click_on_pim_page() {
	pim.clickPim();
	
}

@When("user validate url by using url")
public void user_validate_url_by_using_url(DataTable dataTable) throws InterruptedException {
	
	List<List<String>> list = dataTable.asLists();
	String val = list.get(0).get(0);
	Thread.sleep(5000);
	String url = driver.getCurrentUrl();
	boolean b = url.contains(val);
	Assert.assertEquals(b, true);
	
}

@When("user click on addemployee link an d enter {String},{String} and click on save button")
public void user_click_on_addemployee_link_an_d_enter_and_click_on_save_button(String firstname, String lastname) {
	
	pim.addData(firstname, lastname);
	
}

@When("capture the employee id and click on employee list")
public void capture_the_employee_id_and_click_on_employee_list() throws InterruptedException {
	
	Thread.sleep(5000);
	eid = pim.captureEidandClickOnEmployeeList();
	Thread.sleep(5000);
}

@When("enter employee id in employee id and click on search button")
public void enter_employee_id_in_employee_id_and_click_on_search_button() {
	
	pim.clickOnSearch(eid);
}


@When("select the search employee and click on delete")
public void select_the_search_employee_and_click_on_delete() throws InterruptedException {
	
	
	pim.checkElementAndDelete();
}

@Then("validate user delete or not")
public void validate_user_delete_or_not() {
	String msg = pim.checkDeleteOrNot(eid);
	Assert.assertEquals(msg, "No Records Found");
}

@AfterStep
public void tearDown(Scenario scenario) {
	if (scenario.isFailed()) {
		byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		scenario.attach(f, "image/png", date + scenario.getName());
	} else {
		byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		scenario.attach(f, "image/png", date + scenario.getName());
	
	}

}
}