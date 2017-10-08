package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver wd;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {


    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    }
    else if (browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }
    else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(this);
    navigationHelper = new NavigationHelper(this);
    sessionHelper = new SessionHelper(this);
    contactHelper = new ContactHelper(this);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
