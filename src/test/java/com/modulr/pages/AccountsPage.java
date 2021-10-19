package com.modulr.pages;

import com.modulr.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
    public AccountsPage (){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Add new account']")
    public WebElement addNewAccount;
}
