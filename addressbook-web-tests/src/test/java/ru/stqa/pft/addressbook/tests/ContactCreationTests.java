package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import static java.lang.Integer.compare;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  app.goTo().groupPage();
  if (!app.group().isThereConcreteGroup("test1")){
    app.group().create(new GroupData().withName("test1"));
  }
  app.goTo().mainPage();
}

  @Test
  public void testContactCreation() {


    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("First2").withLastName("Last2").withHomePhone("1234567").withEMail("test2@mailtest.com").withGroup("test1");
    app.contact().create(contact, true);

    Contacts after = app.contact().all();
    contact.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    assertThat(after, equalTo(before.withAdded(contact)));

  }

}
