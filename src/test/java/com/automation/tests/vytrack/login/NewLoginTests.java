package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is "Dashboard"
     */

    @Test
    public void verifyPageTitle(){

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

/**
 * Enter wrong credentials and verify waring message
 */

@Test
    public void verifyWarningMessage(){
                LoginPage loginPage= new LoginPage();
                loginPage.login("Storemanager100", "12345");
                Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
                //take a screenshot
                BrowserUtils.getScreenshot("warning_message");
    }
}
