package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase{


    
    @Test
    public void testContactDelete() {
      app.getNavigationHelper().goToMainPage();
      if (!app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("Last4", "12346567", null, "First4", null), true);
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size()-1);
      app.getContactHelper().deleteContact();
      app.getContactHelper().closeConfirmationDialog();
      app.getNavigationHelper().goToMainPage();
      List<ContactData> after = app.getContactHelper().getContactList();
      before.remove(before.size()-1);
      Assert.assertEquals(before,after);

        }


    

}
