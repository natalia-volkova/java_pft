package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("Last2", "12346567", "test2@mailtest.com", "First2"));
    submitContactCreation();
    goToMainPage();
  }

}
