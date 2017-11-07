package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RegistrationTests extends TestBase{
<<<<<<< HEAD

=======
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
<<<<<<< HEAD
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String email = String.format("user%s@localhost.localdomain", now);
        String user = String.format("user%s", now);
        String password = "password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink= findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        Assert.assertTrue(app.newSession().login(user, password));


    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
       MailMessage mailMessage = mailMessages.stream().filter((m)->m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
=======
    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
        app.mail().waitForMail(2, 10000);
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118
    }

    @AfterMethod(alwaysRun=true)
    public void stopMailServer(){
        app.mail().stop();
    }
}