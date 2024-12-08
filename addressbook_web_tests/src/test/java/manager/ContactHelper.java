package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager){
       super(manager);
    }

    public void openContactCreatePage() {
        if (!manager.isElementPresent(By.linkText("Number of results:"))) {
            click(By.linkText("add new"));
        }
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.linkText("Edit / add address book entry"))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactCreatePage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectContact();
    }
    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectContact();
    }

    private void removeSelectContact() {
        click(By.cssSelector("input[value=Delete]"));
    }

    private void selectAllContacts() {
        click(By.id("MassCB"));
    }

    public void selectContact(ContactData contact) {
        click(By.id(contact.id()));

    }
    private void returnToHomePage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("middlename"), contact.middle_name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());

    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.name("selected[]"));
        for (var td : tds) {

            var id = td.getAttribute("id");
            contacts.add(new ContactData().withId(id));
        }
        return contacts;
    }
}
