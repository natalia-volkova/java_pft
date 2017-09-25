package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){

    app.getNavigationHelper().goToMainPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().clickEditIcon();
    app.getContactHelper().fillContactForm(new ContactData("Last2 Modified", "12346567", "test2@mailtest.com", "First2 modified"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToMainPage();

  }

}
