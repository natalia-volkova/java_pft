package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String lastName;
  private final String homePhone;
  private final String eMail;
  private final String firstName;

  public ContactData(String lastName, String homePhone, String eMail, String firstName) {
    this.lastName = lastName;
    this.homePhone = homePhone;
    this.eMail = eMail;
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String geteMail() {
    return eMail;
  }

  public String getFirstName() {
    return firstName;
  }
}
