package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;


public class TestBase {

  protected static final ApplicationManager app =
          new ApplicationManager(System.getProperty("browser", BrowserType.CHROME ));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    //app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  @AfterSuite
  public void tearDown() throws IOException {
    app.stop();
    //app.ftp().restore("config_inc.php.bak", "config_inc.php");

  }
  boolean isIssueOpenMantis(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    Issue issue = app.soap().getIssue(issueId);
    if (issue.getStatus().toLowerCase().equals("closed")||issue.getStatus().toLowerCase().equals("resolved")){
      return false;
    }
    else return true;
  }

  boolean isIssueOpenBugify(int issueId) throws IOException, ServiceException {
    Issue issue = app.rest().getIssue(issueId);
    if (issue.getStateName().toLowerCase().equals("closed")||issue.getStateName().toLowerCase().equals("resolved")){
      return false;
    }
    else return true;
  }


  public void skipIfNotFixed(int issueId) throws IOException, ServiceException {
    if (isIssueOpenBugify(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }



}
