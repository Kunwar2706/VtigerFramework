package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.libraries.WebDriverUtility;

public class  CreateNewFaqPage {
@FindBy(xpath="//img[@alt='Select']")
private WebElement lookup;

@FindBy(name="faqstatus")
private WebElement faqstatus;


@FindBy(name="question")
private WebElement question;

@FindBy(name="faq_answer")
private WebElement faq_answer;

@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebtn;

// intializtion
public CreateNewFaqPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);

}
//utilization

public WebElement getLookup() {
	return lookup;
}

public WebElement getFaqstatus() {
	return faqstatus;
}

public WebElement getQuestion() {
	return question;
}

public WebElement getFaq_answer() {
	return faq_answer;
}

public WebElement getSavebtn() {
	return savebtn;
}
// business logick
public void clickLokUp() {
	lookup.click();
}
public void selectStatus(WebDriverUtility WLib,String Vtext) {
	WLib.select(Vtext, faqstatus);
	
}

public void GetQues(String QUESTION ) {
	
	question.sendKeys(QUESTION);
}
public void Getans(String ANSWER) {
	
	question.sendKeys(ANSWER);
}

public void SaveBtn() {
	
	savebtn.click();
}

}

