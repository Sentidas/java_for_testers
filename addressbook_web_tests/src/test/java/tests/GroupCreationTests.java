package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.openGroupsPage();
        app.createGroup(new GroupData("", "", ""));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithHeaderOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withFooter("some footer"));
    }
}
