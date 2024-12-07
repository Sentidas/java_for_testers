package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData("", "", ""));
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some group name");
        app.groups().createGroup(groupWithName);
    }

    @Test
    public void CanCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some group header"));
    }

    @Test
    public void CanCreateGroupWithFooterOnly() {
        app.groups().createGroup(new GroupData().withFooter("some group footer"));
    }
}
