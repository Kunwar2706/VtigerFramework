package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateOrganizationPage {
	@FindBy(name="accountname")
	private WebElement orgName;
	
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//Initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	  //business logic
	public void getOrganizationInfo(String orgName,String industry,String type,JavaUtility jlib, WebDriverUtility wLib) {
		this.orgName.sendKeys(orgName+jlib.getRandomNo());
		wLib.select(industryDD, industry);//select by value
		wLib.select(typeDD, type);
		saveButton.click();
	}

	
	

}
