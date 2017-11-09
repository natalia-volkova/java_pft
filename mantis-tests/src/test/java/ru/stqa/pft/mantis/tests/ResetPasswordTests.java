package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ResetPasswordTests extends TestBase{

        @BeforeMethod
        public void startMailServer(){
            app.mail().start();
        }

       @BeforeMethod
        public void ensurePreconditions() throws IOException, MessagingException {
            if (app.db().users().size() == 0) {
                long now = System.currentTimeMillis();
                String email = String.format("user%s@localhost.localdomain", now);
                String user = String.format("user%s", now);
                String password = "password";
                app.registration().create(new UserData().withID(Integer.MAX_VALUE).withUsername(user).withEmail(email), password);

            }
        }

        @Test
        public void testRegistration() throws IOException, MessagingException {

            String newPassword = "password1";
            List<UserData> users = app.db().users();
            UserData modifieduser = users.iterator().next();
            String username = modifieduser.getUsername();
            String email = modifieduser.getEmail();
            app.user().loginAdmin();
            app.user().openUsersList();
            app.user().resetPassword(username);
            List<MailMessage> mailMessages = app.mail().waitForMail(1, 100000);
            String confirmationLink= app.registration().findConfirmationLink(mailMessages, email);
            app.registration().finish(confirmationLink, newPassword);
            Assert.assertTrue(app.newSession().login(username, newPassword));


        }

        @AfterMethod(alwaysRun=true)
        public void stopMailServer(){
            app.mail().stop();
        }



}
