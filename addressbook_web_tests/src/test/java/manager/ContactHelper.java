package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {

    private final ApplicationManager manager;


    public ContactHelper(ApplicationManager manager){
        this.manager = manager;
    }

    public void openContactCreatePage() {
        if (!manager.isElementPresent(By.linkText("Number of results:"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.linkText("Edit / add address book entry"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactCreatePage();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.first_name());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middle_name());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.last_name());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }
}
