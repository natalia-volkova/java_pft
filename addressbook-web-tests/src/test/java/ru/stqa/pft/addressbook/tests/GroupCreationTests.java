package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1").withHeader("test1 header").withFooter("test1 footer");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    group.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    assertThat(after, equalTo(before.withAdded(group)));

  }

}
