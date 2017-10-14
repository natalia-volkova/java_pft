package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()){
      app.group().CreateGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupDeletion() {


    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    app.group().selectGroup(index);
    app.group().deleteSelectedGroups();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().list();
    before.remove(index);
    Assert.assertEquals(after, before);
  }


}
