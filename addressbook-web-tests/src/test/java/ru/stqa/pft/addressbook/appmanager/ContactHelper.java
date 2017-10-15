package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

  public ContactHelper(ApplicationManager app) {
    super(app);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstName() );
    type(By.name("lastname"),contactData.getLastName() );
    type(By.name("home"),contactData.getHomePhone() );
    type(By.name("email"),contactData.geteMail() );

    if (creation)
    {
      if (!(contactData.getGroup() == null)){
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }

    }
    else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
     }


  public void initCreation() {
    click(By.linkText("add new"));
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void delete() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeConfirmationDialog(){
    wd.switchTo().alert().accept();
  }


  public void clickEditIcon(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void submitModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean creation){
    initCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    app.goTo().mainPage();
  }

  public void modify( ContactData contact) {
    clickEditIconByID(contact.getId());

    fillContactForm(contact, false);
    submitModification();
    app.goTo().mainPage();
  }

  private void clickEditIconByID(int id) {
      WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
      WebElement contactRow = checkbox.findElement(By.xpath("./../../."));
      contactRow.findElement(By.xpath(".//img[@title='Edit']")).click();
  }

  public void delete(int index) {
    select(index);
    delete();
    closeConfirmationDialog();
    app.goTo().mainPage();
  }

  public void delete(ContactData contact) {
    selectById(contact.getId());
    delete();
    closeConfirmationDialog();
    app.goTo().mainPage();
  }

  private void selectById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  public List<ContactData> list() {
    List contacts = new ArrayList<ContactData>();
    List <WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element: elements){
      List <WebElement> contactEntries = element.findElements(By.cssSelector("td"));

      String firstName = contactEntries.get(2).getText();
      String lastName = contactEntries.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withLastName(lastName).withFirstName(firstName);
      contacts.add(contact);

    }

    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List <WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element: elements){
      List <WebElement> contactEntries = element.findElements(By.cssSelector("td"));

      String firstName = contactEntries.get(2).getText();
      String lastName = contactEntries.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withLastName(lastName).withFirstName(firstName);
      contacts.add(contact);

    }

    return contacts;
  }
}
