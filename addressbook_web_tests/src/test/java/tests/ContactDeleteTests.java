package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDeleteTests extends TestBase {

    @Test
    public void CanDeleteOneContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("","first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
        }
        List<ContactData> oldContacts = app.contacts().getList();
        var index = new Random().nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        List<ContactData> newContacts = app.contacts().getList();
        List<ContactData> expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        assertEquals(newContacts, expectedList);

    }

    @Test
    public void CanDeleteAllContacts() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("","first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
            app.contacts().createContact(new ContactData("","first_name", "middle_name", "last_name", "address",
                    "email", "mobile"));
        }
        app.contacts().removeAllContacts();
    }
}
