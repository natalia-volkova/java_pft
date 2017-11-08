package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
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
        public void ensurePreconditions() {
            if (app.db().users().size() == 1) {
                long now = System.currentTimeMillis();
                String email = String.format("username%s@localhost", now);
                String username = String.format("username%s", now);
                app.registration().create(new UserData().withID(Integer.MAX_VALUE).withUsername(username).withEmail(email));

            }
        }

        @Test
        public void testRegistration() throws IOException, MessagingException {
            long now = System.currentTimeMillis();

            String newPassword = "password1";

            List<UserData> users = app.db().users();
            UserData modifieduser = users.iterator().next();
            String username = modifieduser.getUsername();
            String email = modifieduser.getEmail();
            app.user().openUsersList();
            app.user().resetPassword(username);

            List<MailMessage> mailMessages = app.james().waitForMail(username, password, 100000);
            String confirmationLink= findConfirmationLink(mailMessages, email);
            app.registration().finish(confirmationLink, newPassword);
            Assert.assertTrue(app.newSession().login(username, newPassword));


        }

        private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
            MailMessage mailMessage = mailMessages.stream().filter((m)->m.to.equals(email)).findFirst().get();
            VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
            return regex.getText(mailMessage.text);
        }

        @AfterMethod(alwaysRun=true)
        public void stopMailServer(){
            app.mail().stop();
        }


    }
}