package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {

    app.getContactHelper().createContact(new ContactData("Last4", "12346567", "test2@mailtest.com", "First2", "test1"), true);
    app.getNavigationHelper().goToMainPage();
  }

}
