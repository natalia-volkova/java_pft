package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Last2", "12346567", "test2@mailtest.com", "First2"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToMainPage();
  }

}