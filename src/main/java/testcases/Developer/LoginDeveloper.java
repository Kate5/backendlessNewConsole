package main.java.testcases.Developer;

import junit.framework.Assert;
import main.java.pages.Developer.BackendlessLoginPage;
import main.java.pages.Developer.BackendlessMainPage;
import org.junit.Ignore;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static main.java.setup.SeleniumDriver.clearBrowserCache;
import static main.java.setup.SeleniumDriver.getDriver;

/**
 * Created by backendlessdev on 5/19/15.
 */

@Ignore
public class LoginDeveloper
{
  //TODO
  // create test account for console tests

  public static final String FIRTS = "test";
  public static final String LAST = "test";
  public static final String EMAIL = "foo@foo.com";
  public static final String PASSWORD = "";
  public static final String INCORRECT_PASSWORD = "111";
  public static final String LOGIN = "";

  @Test( groups = { "positive" } )
  public void loginWithCorrectCredentials()
  {
    BackendlessLoginPage loginPage = new BackendlessMainPage().open().goToLoginPage();
    loginPage.loginDeveloper( EMAIL, PASSWORD );
    getDriver().manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );
    assertTrue( loginPage.getLoggedInDeveloperName().getText().contains( FIRTS + " " + LAST ) );
    //assertTrue( loginPage.getLoggedInDeveloper().getText().contains( FIRTS + " " + LAST ) );
    //assertTrue( loginPage.getWelcomeUser().getText().contains( LOGIN ) );
  }

  @Test( groups = { "negative" } )
  public void loginWithNotCorrectCredentials()
  {
    BackendlessLoginPage loginPage = new BackendlessMainPage().open().goToLoginPage();
    loginPage.loginDeveloper( EMAIL, INCORRECT_PASSWORD );
    assertTrue("Incorrect toaster message for login in developer with incorrect password", loginPage.checkToaster( "Invalid developer's login or password" ));
    getDriver().manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );
  }

  @Test( groups = { "positive" } )
  public void loginWithFacebook()
  {
    BackendlessLoginPage loginPage = new BackendlessMainPage().open().goToLoginPage();
    loginPage.getFacebookLogin().click();
    getDriver().manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );
  }

  @Test( groups = { "positive" } )
  public void loginWithTwitter()
  {
    BackendlessLoginPage loginPage = new BackendlessMainPage().open().goToLoginPage();
    loginPage.getTwitterLogin().click();
    getDriver().manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );
  }

  @AfterMethod
  public static void clearCache()
  {
    clearBrowserCache();
  }

  @AfterClass
  public static void tearDown()
  {
    clearBrowserCache();
    getDriver().close();
  }
}



