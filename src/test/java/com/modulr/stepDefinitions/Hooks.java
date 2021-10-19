package com.modulr.stepDefinitions;

import com.modulr.utilities.Driver;
import gherkin.ast.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp(){

        Driver.get().manage().window().maximize();
    }


    @After
    public void tearDown(){


        Driver.closeDriver();

    }

}
