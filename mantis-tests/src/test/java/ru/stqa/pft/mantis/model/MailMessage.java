<<<<<<< HEAD
package ru.stqa.pft.mantis.model;

        public class MailMessage {
=======
package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class MailMessage {
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118
    public String to;
    public String text;

    public MailMessage(String to, String text){
        this.to = to;
        this.text = text;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 8c4ced4695cedaa713ffba0b8c988130996de118
