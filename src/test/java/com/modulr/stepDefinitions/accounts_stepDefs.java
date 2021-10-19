package com.modulr.stepDefinitions;

import com.modulr.pages.AccountsPage;
import com.modulr.pages.SignInPage;
import com.modulr.utilities.ConfigurationReader;
import com.modulr.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class accounts_stepDefs {
    AccountsPage accountsPage = new AccountsPage();
    SignInPage signInPage = new SignInPage();
    Driver driver = new Driver();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signInPage.userName.sendKeys(ConfigurationReader.get("validUsername"));
        signInPage.password.sendKeys(ConfigurationReader.get("validPassword"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signInPage.signInButton.click();
        Thread.sleep(10000);
        System.out.println("I am logged in ");


    }

    @When("I click on Add new account")
    public void i_click_on_Add_new_account() throws InterruptedException {
        accountsPage.addNewAccount.click();
        Thread.sleep(3000);
        System.out.println("I click on new account");
    }

    @Then("I should be on Accounts page")
    public void i_should_be_on_Accounts_page() {
        System.out.println("Driver.get().getWindowHandle() = " + Driver.get().getWindowHandle());
        System.out.println("I am on accounts page");
    }
}
