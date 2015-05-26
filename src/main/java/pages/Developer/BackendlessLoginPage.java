package main.java.pages.Developer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by backendlessdev on 5/19/15.
 */
public class BackendlessLoginPage extends BackendlessPage<BackendlessLoginPage>
{
  // login user

  @FindBy( id = "userId" )
  WebElement emailAddress;

  @FindBy( id = "password" )
  WebElement loginPassword;

  @FindBy( id = "basicLoginButton" )
  WebElement loginButton;

  @FindBy( id = "facebookLoginButton" )
  WebElement facebookLogin;

  @FindBy( id = "twitterLoginButton" )
  WebElement twitterLogin;

  // links on login page

  @FindBy( xpath = ".//*[@id='authorizeBlock']/li[8]/a[1]" )
  WebElement registerLink;

  @FindBy( xpath = ".//*[@id='authorizeBlock']/li[8]/a[2]" )
  WebElement restorePassword;

  @FindBy( xpath = ".//*[@id='resendemail']" )
  WebElement resendConfirmationLink;

  // check for loggedInDeveloper

  @FindBy( className = "login" )
  WebElement loggedInDeveloper;

  @Override
  protected ExpectedCondition getPageLoadCondition()
  {
    //  return ExpectedConditions.visibilityOf( emailAddress );
    return ExpectedConditions.titleContains( "Backendless" );
  }

  @Override
  public String getPageUrl()
  {
    return "/#login";
  }

  public void loginDeveloper( String email, String password )
  {

    emailAddress.sendKeys( email );
    loginPassword.sendKeys( password );
    loginButton.click();
  }

  public WebElement getLoggedInDeveloper()
  {
    return loggedInDeveloper;
  }

  public WebElement getLoggedInDeveloperName()
  {
    return loggedInDeveloper;
  }

  public WebElement getFacebookLogin()
  {
    return facebookLogin;
  }

  public WebElement getTwitterLogin()
  {
    return twitterLogin;
  }
}