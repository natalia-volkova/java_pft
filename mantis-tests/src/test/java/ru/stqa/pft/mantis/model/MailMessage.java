package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class MailMessage {
    public String to;
    public String text;

    public MailMessage(String to, String text){
        this.to = to;
        this.text = text;
    }

}
