package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void CanCreateContactWithFIO() {
        app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name"));
    }

    @Test
    public void CanCreateContactWithEmptyFIO() {
        app.contacts().createContact(new ContactData("", "", ""));
    }

    @Test
    public void CanCreateContactWithFirstNameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("first_name"));
    }

    @Test
    public void CanCreateContactWithMiddleNameOnly() {
        app.contacts().createContact(new ContactData().withMiddleName("middle_name"));
    }

    @Test
    public void CanCreateContactWithLastNameOnly() {
        app.contacts().createContact(new ContactData().withLastName("last_name"));
    }
}
