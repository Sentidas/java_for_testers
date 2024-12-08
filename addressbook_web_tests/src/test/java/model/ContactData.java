package model;

public record ContactData(String id, String first_name, String middle_name, String last_name, String address,
                          String email, String mobile) {
    public ContactData() {
        this("", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.middle_name, this.last_name, this.address, this.email, this.mobile);
    }
    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.middle_name, this.last_name, this.address, this.email, this.mobile);
    }
    public ContactData withMiddleName(String middle_name) {
        return new ContactData(this.id, this.first_name, middle_name, this.last_name, this.address, this.email, this.mobile);
    }
    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name, this.address, this.email, this.mobile);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, middle_name, this.last_name, address, this.email, this.mobile);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name, this.address, email, this.mobile);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name, this.address, this.email, mobile);
    }
}
