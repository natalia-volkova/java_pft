package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

  @DataProvider
  public Iterator<Object []> validContactsXml () throws IOException {

  try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
    String xml = "";
    String line = reader.readLine();
    while (line!=null){
      xml+=line;
      line= reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  }

  @DataProvider
  public Iterator<Object []> validContactsJson () throws IOException {
  try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
    String json = "";
    String line = reader.readLine();
    while (line!=null){
      json+=line;
      line= reader.readLine();
    }
    Gson gson = new Gson();

    List<ContactData> contacts = (List<ContactData>) gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  }

  @Test(dataProvider = "validContactsJson")
  public void testContactCreation(ContactData contact) {


    Contacts before = app.db().contacts();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.db().contacts();
    contact.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());


    assertThat(after, equalTo(before.withAdded(contact)));

  }

}
