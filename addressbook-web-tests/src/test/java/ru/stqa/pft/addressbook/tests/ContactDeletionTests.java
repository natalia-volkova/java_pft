package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().mainPage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withLastName("Last4").withHomePhone("111"), true);
      app.goTo().mainPage();
    }
  }

    
    @Test
    public void testContactDelete() {

      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size()-1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.without(deletedContact)));

        }




}
