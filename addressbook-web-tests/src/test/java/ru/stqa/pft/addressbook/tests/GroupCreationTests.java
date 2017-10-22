package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator <Object []> validGroups () throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line!=null){
      xml+=line;
      line= reader.readLine();
    }
    XStream xstream = new XStream();
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();

  }

  @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {

    app.goTo().groupPage();
    Groups before = app.group().all();
   // GroupData group = new GroupData().withName("test1").withHeader("test1 header").withFooter("test1 footer");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    group.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    assertThat(after, equalTo(before.withAdded(group)));

  }

}
