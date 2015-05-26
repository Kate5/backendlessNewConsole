package main.java.pages.Developer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by backendlessdev on 5/19/15.
 */
public class BackendlessRegistrationPage extends BackendlessPage<BackendlessLoginPage>
{

// register developer firstName

  @FindBy( id = "firstName" )
  WebElement registrationFirstName;

  @FindBy( id = "lastName" )
  WebElement registrationLastName;

  @FindBy( id = "password" )
  WebElement registrationPassword;

  @FindBy( id = "email" )
  WebElement registrationEmail;

  @FindBy( id = "appName" )
  WebElement registrationAppName;

  @FindBy( id = "recaptcha_response_field" )
  WebElement registrationRecaptcha;

  @FindBy( className = "submit loginSubmit" )
  WebElement registrationButton;

  @Override
  protected ExpectedCondition getPageLoadCondition()
  {
    return null;
  }

  @Override
  public String getPageUrl()
  {
    return "/#registration";
  }

  public void registerDeveloper( String firstName, String lastName, String email, String password, String appName,
                                 String capcha )
  {

    registrationFirstName.sendKeys( firstName );
    registrationLastName.sendKeys( lastName );
    registrationPassword.sendKeys( password );
    registrationEmail.sendKeys( email );
    registrationAppName.sendKeys( appName );
    registrationRecaptcha.sendKeys( capcha );
    registrationButton.click();
  }
}














