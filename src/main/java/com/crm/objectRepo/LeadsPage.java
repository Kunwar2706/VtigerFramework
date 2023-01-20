package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	//declaration
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement clickOnCreateLeadPopup;

//intialization
 public LeadsPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 //Utilization
public WebElement getClickOnCreateLeadPopup() {
	return clickOnCreateLeadPopup;
}
	
	public void getCreateLead()
	{
		clickOnCreateLeadPopup.click();
	}
}
 

 
 

