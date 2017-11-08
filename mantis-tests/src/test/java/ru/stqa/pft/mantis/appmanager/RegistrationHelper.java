package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

<<<<<<< HEAD
public class RegistrationHelper extends HelperBase{


    public RegistrationHelper(ApplicationManager app){
=======
public class RegistrationHelper{


    public RegistrationHelper(ApplicationManager app) extends HelperBase{
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118
        super(app);
        wd = app.getDriver();
    }


    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
<<<<<<< HEAD
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Signup']"));

    }
=======
        type(By.name("email"), username);
        click(By.cssSelector("input[value='Signup']"));
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}