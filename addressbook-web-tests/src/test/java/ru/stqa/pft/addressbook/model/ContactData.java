package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id= Integer.MAX_VALUE;;
  private  String lastName;
  private  String firstName;
  private  String homePhone;
  private  String mobile;
  private  String workPhone;
  private  String fax;
  private  String phone2;
  private  String eMail;
  private  String eMail2;
  private  String eMail3;
  private  String address;
  private String group;
  private String allPhones;
  private String allEmails;



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }


  public ContactData withEMail(String eMail) {
    this.eMail = eMail;
    return this;
  }

  public ContactData withEMail2(String eMail2) {
    this.eMail2 = eMail2;
    return this;
  }

  public ContactData withEMail3(String eMail3) {
    this.eMail3 = eMail3;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }



  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkPhone() { return workPhone; }

  public String getFax() {
    return fax;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String geteMail() {
    return eMail;
  }

  public String geteMail2() {
    return eMail2;
  }

  public String geteMail3() {
    return eMail3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAddress() {
    return address;
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

    if (id != that.id) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    return result;
  }
}
