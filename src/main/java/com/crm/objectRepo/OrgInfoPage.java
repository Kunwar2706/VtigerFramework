package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// declaration
public class OrgInfoPage {
@FindBy(className = "dvHeaderText")
private WebElement orgInformation;

// Initialization

public  OrgInfoPage(WebDriver driver) {
PageFactory.initElements(driver, this);


}
//utilization

public WebElement getOrgInformation() {
	return orgInformation;
}


public String getOrgHeaderInfo()
{
	return orgInformation.getText();
}

}