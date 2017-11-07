package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
        app.mail().waitForMail(2, 10000);
    }

    @AfterMethod(alwaysRun=true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
