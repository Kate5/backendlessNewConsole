package main.java.pages.Developer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by backendlessdev on 5/19/15.
 */
public class BackendlessRestorePasswordPage extends BackendlessPage<BackendlessLoginPage>
{

// restore password

  @FindBy( id = "email" )
  WebElement emailAddressValueForRestore;

  @FindBy( className = "submit loginSubmit loginRestore" )
  WebElement restorePasswordButton;

  @Override
  protected ExpectedCondition getPageLoadCondition()
  {
    return null;
  }

  @Override
  public String getPageUrl()
  {
    return "/#forgotpassword";
  }

  public void restoreDeveloperPassword( String email )
  {
    emailAddressValueForRestore.sendKeys( email );
    restorePasswordButton.click();
  }
}
