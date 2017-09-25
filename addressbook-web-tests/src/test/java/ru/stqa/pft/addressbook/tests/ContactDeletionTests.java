package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    
    @Test
    public void testContactDelete() {
      app.getNavigationHelper().goToMainPage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().closeConfirmationDialog();
      app.getNavigationHelper().goToMainPage();

        }


    

}
