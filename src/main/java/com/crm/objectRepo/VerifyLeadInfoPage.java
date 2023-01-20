package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLeadInfoPage {
	// Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadInfomation;
	
	// initialization 
	
public  VerifyLeadInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	//utilization
	
}

//utilization
public WebElement getLeadInfomation() {
	return leadInfomation;
	}
	
	//businesslogic
	public String getLeadHeaderInfo()
	{
		return leadInfomation.getText();
	}
}

