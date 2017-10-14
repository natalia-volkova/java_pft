package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class ContactModificationTests extends TestBase{
@BeforeMethod
public void ensurePreconditions(){
  app.goTo().mainPage();
  if (!app.contact().isThereAContact()){
    app.contact().create(new ContactData("Last4", "12346567", null, null, null), true);
    app.goTo().mainPage();
  }

}
  @Test
  public void testContactModification(){


    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(), "Last2 Modified", "12346567", "test2@mailtest.com", "First2 modified", null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId;
    byId = (Comparator<ContactData>) (o1, o2) -> compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }



}
