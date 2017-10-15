package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.compare;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size()==0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {


    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("test3 modify").withHeader("test3 logo").withFooter("test3 footer");


    app.group().modify(group);
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
