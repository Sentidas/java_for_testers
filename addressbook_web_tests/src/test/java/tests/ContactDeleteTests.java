package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void CanDeleteOneContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name"));
        }
        app.contacts().removeContact();
    }

    @Test
    public void CanDeleteAllContacts() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first_name1", "middle_name1", "last_name1"));
            app.contacts().createContact(new ContactData("first_name2", "middle_name2", "last_name2"));
        }
        app.contacts().removeAllContacts();
    }
}
