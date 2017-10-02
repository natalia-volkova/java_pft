package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereConcreteGroup("test1")){
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
    }
    app.getContactHelper().createContact(new ContactData("Last4", "12346567", "test2@mailtest.com", "First2", "test1"), true);

  }

}
