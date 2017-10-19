package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import ru.stqa.pft.addressbook.model.Contacts;

import static java.lang.Integer.compare;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{
@BeforeMethod
public void ensurePreconditions(){
  app.goTo().mainPage();
  if (app.contact().all().size()==0){
    app.contact().create(new ContactData().withLastName("Last4").withHomePhone("111"), true);
    app.goTo().mainPage();
  }

}
  @Test
  public void testContactModification(){


    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withLastName("Last2 Modified").withFirstName("First2 modified").withHomePhone("12346567").withEMail("test2@mailtest.com");

    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withModified(modifiedContact, contact)));

  }



}
