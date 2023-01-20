package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreatingNewLeadPage {

@FindBy(name="salutationtype")
private WebElement DropDD;

@FindBy(name="firstname")
private WebElement firstName;


@FindBy(name="lastname")
private WebElement LastName;

@FindBy(name="company")
private WebElement comName;

@FindBy(name="leadsource")
private WebElement leadsourceDD;

@FindBy(name="industry")
private WebElement industryDD;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

//Initialization
 public CreatingNewLeadPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
 //utilization
 public WebElement getDropDD() {
		return DropDD;
 }

public WebElement getFirstName() {
	return firstName;
}

public WebElement getLastName() {
	return LastName;
}

public WebElement getComName() {
	return comName;
}

public WebElement getLeadsourceDD() {
	return leadsourceDD;
}

public WebElement getIndustryDD() {
	return industryDD;
}

public WebElement getSaveButton() {
	return saveButton;
}
 //bussiness logic
public void getLeadInfo(WebDriverUtility wLib,String None,String frstName ,String lastName,String cmpnyName,JavaUtility jLib,String leadSource,String industry){
	wLib.select(DropDD,None);
	firstName.sendKeys(frstName);
	LastName.sendKeys(lastName);
	comName.sendKeys(cmpnyName);
	wLib.select(leadsourceDD,leadSource);
	wLib.select(industryDD,industry );//select by value
	saveButton.click();
	
}
}
