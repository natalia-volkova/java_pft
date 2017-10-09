package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification(){

    app.getNavigationHelper().goToMainPage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Last4", "12346567", null, null, null), true);

    }
    app.getNavigationHelper().goToMainPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    //app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().clickEditIcon(before.size()-1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Last2 Modified", "12346567", "test2@mailtest.com", "First2 modified", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToMainPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId;
    byId = (Comparator<ContactData>) (o1, o2) -> compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}
