package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.compare;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()){
      app.group().CreateGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupModification() {


    List<GroupData> before = app.group().list();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"test2_modify", "test2 logo", "test2 footer");

    app.group().modifyGroup(before, group);
    List<GroupData> after = app.group().list();
    before.remove(before.size()-1);
    before.add(group);
    Comparator<? super GroupData> byId;
    byId = (Comparator<GroupData>) (o1, o2) -> compare(o1.getId(), o2.getId());

    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
