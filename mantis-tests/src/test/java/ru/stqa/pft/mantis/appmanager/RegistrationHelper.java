package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper{


    public RegistrationHelper(ApplicationManager app) extends HelperBase{
        super(app);
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), username);
        click(By.cssSelector("input[value='Signup']"));

    }
}
