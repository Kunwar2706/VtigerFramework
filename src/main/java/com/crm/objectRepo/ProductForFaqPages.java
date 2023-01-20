package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtility;

public class ProductForFaqPages {
@FindBy(xpath="//input[@name='search_text']")
public WebElement searchtext;

@FindBy(name="search_field")
public  WebElement prodTypeDD;

@FindBy(name="search")
private  WebElement searchNow;


// itializtion
public ProductForFaqPages(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utiliztion


public WebElement getSearchtext() {
	return searchtext;
}


public WebElement getProdType() {
	return prodTypeDD;
}


public WebElement getSearchNow() {
	return searchNow;
}
// bussinessLogic 
public void searchTextField(String pName) {
	searchtext.sendKeys(pName);
}
public void producType(WebDriverUtility wLib,String vtext) {
	wLib.select(vtext, prodTypeDD);
}
	
	public void getSearchNwbtn() {
		searchNow.click();
	}
}