package com.parabank.pom.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.pom.BaseParaBankTest;

public class CustomerLogin extends BaseParaBankTest {
@FindBy(name="username")
WebElement usernameEl;

@FindBy(name="password")
WebElement passwordEl;

@FindBy(css="input.button")
WebElement loginBtn;

@FindBy(className="error")
List<WebElement>errors;

public CustomerLogin() {
	
	PageFactory.initElements(driver, this);
		
}
public CustomerLogin fillusername(String username) {
	usernameEl.isDisplayed();
	usernameEl.clear();
	usernameEl.sendKeys(username);
	return this;
}
public CustomerLogin fillpassword(String password) {
	usernameEl.isDisplayed();
	usernameEl.clear();
	usernameEl.sendKeys(password);
	return this;
}
public  HomePage clickLoginBtn(){
	loginBtn.isDisplayed();
	loginBtn.click();
	return new HomePage();
}
public CustomerLogin  clicCustomerkLoginBtn(){
	loginBtn.isDisplayed();
	loginBtn.click();
	return this;
}
public boolean hasError() {
	return errors.size()>0;
}


}