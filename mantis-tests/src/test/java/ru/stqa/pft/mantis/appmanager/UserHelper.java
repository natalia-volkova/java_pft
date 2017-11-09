package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void openUsersList (){
        click(By.linkText("Manage Users"));
    }

    public void select(String username){
        type(By.name("username"),username);
        click(By.cssSelector("input[value='Manage User']"));

    }

    public void resetPassword(String user){
        select(user);
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void loginAdmin(){
        app.user().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    }


}
