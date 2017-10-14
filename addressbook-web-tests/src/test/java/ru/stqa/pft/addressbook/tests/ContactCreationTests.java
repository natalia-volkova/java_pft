package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class ContactCreationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  app.goTo().groupPage();
  if (!app.group().isThereConcreteGroup("test1")){
    app.group().CreateGroup(new GroupData("test1", null, null));
  }
  app.goTo().mainPage();
}

  @Test
  public void testContactCreation() {


    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Last4", "12346567", "test2@mailtest.com", "First2", "test1");
    app.contact().create(contact, true);

    List<ContactData> after = app.contact().list();
    Comparator<? super ContactData> byId;
    byId = (Comparator<ContactData>) (o1, o2) -> compare(o1.getId(), o2.getId());

    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
