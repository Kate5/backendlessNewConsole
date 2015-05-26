package main.java.pages.Developer;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by backendlessdev on 5/20/15.
 */
public class BackendlessMainPage extends BackendlessPage<BackendlessMainPage>
{

//  @FindBy(id = "")
//  WebElement ;
//
//  @FindBy(id = "")
//  WebElement ;
//
//  @FindBy (className = "" )
//  WebElement ;

  @Override
  protected ExpectedCondition getPageLoadCondition()
  {
    return ExpectedConditions.titleContains( "Backendless" );
  }

  @Override
  public String getPageUrl()
  {
    return "";
  }

  public BackendlessLoginPage goToLoginPage()
  {
    return new BackendlessLoginPage().openPage( BackendlessLoginPage.class );
  }

  public BackendlessMainPage open()
  {
    return new BackendlessMainPage().openPage( BackendlessMainPage.class );
  }
}










