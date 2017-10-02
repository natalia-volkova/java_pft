package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){

    app.getNavigationHelper().goToMainPage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Last4", "12346567", null, null, null), true);

    }
    app.getContactHelper().selectContact();
    app.getContactHelper().clickEditIcon();
    app.getContactHelper().fillContactForm(new ContactData("Last2 Modified", "12346567", "test2@mailtest.com", "First2 modified", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToMainPage();

  }

}
