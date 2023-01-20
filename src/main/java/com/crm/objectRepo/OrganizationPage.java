package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createOganization;
	
	//Initialization
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getCreateOganization() {
		return createOganization;
	}
	//business logic
	public void createOrgPopup() {
		createOganization.click();
	}
	

}
