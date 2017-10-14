package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().mainPage();
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData("Last4", "12346567", null, null, null), true);
      app.goTo().mainPage();
    }
  }

    
    @Test
    public void testContactDelete() {

      List<ContactData> before = app.contact().list();
      int index = before.size()-1;
      app.contact().delete(index);
      List<ContactData> after = app.contact().list();
      before.remove(index);
      Assert.assertEquals(before,after);

        }




}
