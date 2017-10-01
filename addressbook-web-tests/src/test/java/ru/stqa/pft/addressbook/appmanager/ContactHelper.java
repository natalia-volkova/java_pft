package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
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



  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeConfirmationDialog(){
    wd.switchTo().alert().accept();
  }

  public void confirmContactDeletion() {
   //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickEditIcon() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void createContact(ContactData contact, boolean creation){
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
   // app.goToMainPage();
  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }
}
