package main.java.pages.Developer;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static main.java.setup.SeleniumDriver.getDriver;

/**
 * Created by backendlessdev on 5/19/15.
 */

public abstract class BackendlessPage<T>
{
  private static final String BASE_URL = "http://localhost";
//  private static final String BASE_URL = "http://develop.backendless.com";
  private static final int LOAD_TIMEOUT = 50;
  private static final int REFRESH_RATE = 2;

  public T openPage( Class<T> clazz )
  {
    T page = PageFactory.initElements( getDriver(), clazz );
    getDriver().get( BASE_URL + getPageUrl() );
    ExpectedCondition pageLoadCondition = ((BackendlessPage) page).getPageLoadCondition();
    waitForPageToLoad( pageLoadCondition );
    return page;
  }

  public boolean checkToaster( String message )
  {
    WebElement toaster;
    String toasterMessage;

    try
    {
      toaster = getDriver().findElement(By.id( "toast-container" ));
      toasterMessage = getDriver().findElement( By.className( "toast-message" ) ).getText();
    }
    catch ( NoSuchElementException e )
    {
      return false;
    }

    if ( message.equals( toasterMessage ) )
      return true;

    return false;
  }

  private void waitForPageToLoad( ExpectedCondition pageLoadCondition )
  {
    Wait wait = new FluentWait( getDriver() ).withTimeout( LOAD_TIMEOUT, TimeUnit.SECONDS ).pollingEvery( REFRESH_RATE, TimeUnit.SECONDS );

    wait.until( pageLoadCondition );
  }

  public BackendlessLoginPage goToLoginPage() {
    return new BackendlessLoginPage().openPage(BackendlessLoginPage.class);
  }

  protected abstract ExpectedCondition getPageLoadCondition();

  public abstract String getPageUrl();
}