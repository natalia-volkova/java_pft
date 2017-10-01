package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String lastName;
  private final String homePhone;
  private final String eMail;
  private final String firstName;
  private String group;

  public ContactData(String lastName, String homePhone, String eMail, String firstName, String group) {
    this.lastName = lastName;
    this.homePhone = homePhone;
    this.eMail = eMail;
    this.firstName = firstName;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
