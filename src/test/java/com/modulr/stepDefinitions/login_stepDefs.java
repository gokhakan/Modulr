package com.modulr.stepDefinitions;

import com.modulr.pages.SignInPage;
import com.modulr.utilities.ConfigurationReader;
import com.modulr.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.groovy.json.internal.Chr;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login_stepDefs {

    SignInPage signInPage = new SignInPage();
    Driver driver= new Driver();
    String actualUrl;

    @Given("I am on Modulr homepage")
    public void i_am_on_Modulr_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());


    }

    @When("I use valid username and password")
    public void i_use_valid_username_and_password() throws InterruptedException {
    signInPage.userName.sendKeys(ConfigurationReader.get("validUsername"));
    signInPage.password.sendKeys(ConfigurationReader.get("validPassword"));
    Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    signInPage.signInButton.click();
    Thread.sleep(10000);
    Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    actualUrl = Driver.get().getCurrentUrl();
    System.out.println("actualUrl = " + actualUrl);


    }

    @Then("I should be able to login succesfully")
    public void i_should_be_able_to_login_succesfully() {

        String expectedUrl = "https://secure-sandbox.modulrfinance.com/customer/account";
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    @When("I use invalid username and password")
    public void i_use_invalid_username_and_password() {
        signInPage.userName.sendKeys(ConfigurationReader.get("invalidUsername"));
        signInPage.password.sendKeys(ConfigurationReader.get("invalidPassword"));
        signInPage.signInButton.click();

    }

    @Then("I shouldn't be able to login")
    public void i_shouldn_t_be_able_to_login() {
        System.out.println("Driver.get().getCurrentUrl() = " + Driver.get().getCurrentUrl());
    }




}
