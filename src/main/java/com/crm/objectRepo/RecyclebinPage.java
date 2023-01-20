package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtility;

public class RecyclebinPage {
@FindBy(name="search_text")
private WebElement serchFor;

  
@FindBy(name="search_field")
private WebElement In;


@FindBy(name="submit")
private WebElement SeachNow;


//itializtion
public RecyclebinPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utiliztion

public WebElement getSerchFor() {
	return serchFor;
}

public WebElement getIn() {
	return In;
}

public WebElement getSeachNow() {
	return SeachNow;
}


//bussinessLogic 
public void searchTextField(String orgNameDetail) {
	serchFor.sendKeys(orgNameDetail);
}
public void dropDwonIn(WebDriverUtility wLib,String vtext) {
	wLib.select(vtext,In);
}
	
	public  void clickOnSearchNowBtn()
	{
		SeachNow.click();
	}
	

	}



