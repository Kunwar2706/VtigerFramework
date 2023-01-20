package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtility;

public class DelelteOrg_EditOrg {
	@FindBy(name="Delete")
	private WebElement deltBtn;
	
	//intializtion
	public DelelteOrg_EditOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getDeltBtn() {
		return deltBtn;
	}
	//business logic
	 public void clickOndelete(WebDriverUtility wlib,WebDriver driver) {
		 
		 deltBtn.click();
		 wlib.acceptAlert(driver);
		 
	 }
	 
}
