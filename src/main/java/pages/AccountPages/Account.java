package main.java.pages.AccountPages;

import main.java.pages.Developer.BackendlessLoginPage;
import main.java.pages.Developer.BackendlessPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by backendlessdev on 6/17/15.
 */
public class Account extends BackendlessPage<BackendlessLoginPage>
{
  // login user

  @FindBy( id = "column-name" )
  WebElement columnName;

  @FindBy( id = "email-address" )
  WebElement emailAddress;

  @FindBy( id = "company" )
  WebElement company;

  @FindBy( id = "phone" )
  WebElement phone;

  @FindBy( id = "password" )
  WebElement password;

  @FindBy( id = "new-password" )
  WebElement newPassword;

  @FindBy( id = "retype-password" )
  WebElement retypePassword;

  @FindBy( className = "submit" )
  WebElement submitButton;

  @Override
  protected ExpectedCondition getPageLoadCondition()
  {
    return ExpectedConditions.titleContains( "Backendless" );
  }

  @Override
  public String getPageUrl()
  {
    return "/#home/account";
  }

  public void updateDevAccount( String name, String email, String company, String phone, String password,
                                String newPassword, String confirmPassword )
  {

//    emailAddress.sendKeys( email );
//    loginPassword.sendKeys( password );
//    loginButton.click();
  }
//
//    public WebElement getLoggedInDeveloper()
//    {
//      return loggedInDeveloper;
//    }
//
//    public WebElement getLoggedInDeveloperName()
//    {
//      return loggedInDeveloper;
//    }
//
//    public WebElement getFacebookLogin()
//    {
//      return facebookLogin;
//    }
//
//    public WebElement getTwitterLogin()
//    {
//      return twitterLogin;
//    }
}









