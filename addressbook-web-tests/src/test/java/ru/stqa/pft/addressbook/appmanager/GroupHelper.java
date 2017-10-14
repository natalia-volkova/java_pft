package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper (ApplicationManager app) {
    super(app);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void initGroupModification() {
    click(By.name("edit"));
      }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void CreateGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modifyGroup(List<GroupData> before, GroupData group) {
   selectGroup(before.size()-1);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
   returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent((By.name("selected[]")));
  }

  public boolean isThereConcreteGroup(String groupName) {

    try {
      wd.findElement(By.xpath("//span[text()="+groupName+"]"));
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }

  }

  public int getGroupCount(){
    return wd.findElements(By.name("selected[]")).size();
  }

  public List <GroupData> list() {
    List groups = new ArrayList <GroupData>();
    List <WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
}
