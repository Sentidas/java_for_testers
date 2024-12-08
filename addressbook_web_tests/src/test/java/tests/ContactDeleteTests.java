package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void CanDeleteOneContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
        }
        app.contacts().removeContact();
    }

    @Test
    public void CanDeleteAllContacts() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
            app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
        }
        app.contacts().removeAllContacts();
    }
}
