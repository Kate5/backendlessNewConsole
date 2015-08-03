package main.java.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by backendlessdev on 5/19/15.
 */
public class SeleniumDriver
{

  static WebDriver driver;

//  public static WebDriver getDriver()
//  {
//    if( driver == null )
//    {
//      driver = new FirefoxDriver();
//    }
//    driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
//    return driver;
//  }

  // for selenium grid support

  // run selenium grid:
  //java -jar selenium-server-standalone-2.45.0.jar -role hub
  //java -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556

  public static WebDriver getDriver() {
    if (driver == null) {
      DesiredCapabilities capability = DesiredCapabilities.firefox();
      try {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      capability.setBrowserName("firefox" );
      capability.setVersion("38.0.1");
    }
    return driver;
  }

  public static void clearBrowserCache()
  {
    driver.manage().deleteAllCookies(); //delete all cookies
    try
    {
      Thread.sleep( 10000 );
    }
    catch( InterruptedException e )
    {
      e.printStackTrace();
    }
  }
}

