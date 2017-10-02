package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{


    
    @Test
    public void testContactDelete() {
      app.getNavigationHelper().goToMainPage();
      if (!app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("Last4", "12346567", null, null, null), true);

      }
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().closeConfirmationDialog();
      app.getNavigationHelper().goToMainPage();

        }


    

}
