package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereConcreteGroup("test1")){
      app.getGroupHelper().CreateGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().goToMainPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Last4", "12346567", "test2@mailtest.com", "First2", "test1");
    app.getContactHelper().createContact(contact, true);
    app.getNavigationHelper().goToMainPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Comparator<? super ContactData> byId;
    byId = (Comparator<ContactData>) (o1, o2) -> compare(o1.getId(), o2.getId());

    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
