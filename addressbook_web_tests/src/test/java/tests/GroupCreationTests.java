package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.groups().createGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData("", "", ""));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.groups().createGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some header"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("some footer"));
    }
}
