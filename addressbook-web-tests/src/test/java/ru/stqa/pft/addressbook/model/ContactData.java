package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String lastName;
  private final String homePhone;
  private final String eMail;
  private final String firstName;
  private String group;



  public ContactData(String lastName, String homePhone, String eMail, String firstName, String group) {
    this.id = Integer.MAX_VALUE;
    this.lastName = lastName;
    this.homePhone = homePhone;
    this.eMail = eMail;
    this.firstName = firstName;
    this.group = group;
  }

  public ContactData(int id, String lastName, String homePhone, String eMail, String firstName, String group) {

    this.id=id;
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

  public int getId() {    return id;  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
  }



  @Override

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
  }

  @Override
  public int hashCode() {
    int result = lastName != null ? lastName.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    return result;
  }
}
