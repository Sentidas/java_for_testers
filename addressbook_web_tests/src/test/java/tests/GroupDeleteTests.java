package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeleteTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("name", "header", "footer"));
        }
        app.removeGroup();
    }
}
