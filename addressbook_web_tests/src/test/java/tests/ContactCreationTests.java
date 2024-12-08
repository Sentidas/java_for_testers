package tests;

import model.ContactData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "first_name")) {
            for (var middlename : List.of("", "middle_name")) {
                for (var lastname : List.of("", "last_name")) {
                    for (var address : List.of("", "address_name")) {
                        for (var email : List.of("", "email")) {
                            for (var mobile : List.of("", "mobile")) {
                                result.add(new ContactData(firstname, middlename, lastname, address, email, mobile));
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= 5; i++) {
            result.add(new ContactData(ramdomString(i * 10), ramdomString(i * 10), ramdomString(i * 10),
                    ramdomString(i * 10), ramdomString(i * 10), ramdomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        return new ArrayList<>(List.of(
                new ContactData("first ' name", "", "", "", "", ""),
                new ContactData("", "middle ' name", "", "", "", ""),
                new ContactData("", "", "last ' name", "", "", ""),
                new ContactData("", "", "", "address '", "", ""),
                new ContactData("", "", "", "", "email'email", ""),
                new ContactData("", "", "", "", "", "mobile ' fhone")));
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void CanNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        assertEquals(contactCount, newContactCount);
    }


}
