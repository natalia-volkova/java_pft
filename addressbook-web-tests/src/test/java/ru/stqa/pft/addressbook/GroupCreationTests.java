package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
    public void testGroupCreation() {

    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "test2 logo", "test2 footer"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
