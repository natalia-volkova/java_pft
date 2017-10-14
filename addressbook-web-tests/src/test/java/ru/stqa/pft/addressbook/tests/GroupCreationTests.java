package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {

    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData("test1", "test2 logo", "test2 footer");
    app.group().CreateGroup(group);
    List<GroupData> after = app.group().list();
    Comparator<? super GroupData> byId;
    byId = (Comparator<GroupData>) (o1, o2) -> compare(o1.getId(), o2.getId());
    //int max = after.stream().max(byId).get().getId();
    before.add(group);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
